package com.xing.studyboot.component.zookeeper;

import java.io.IOException;
import java.util.List;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * zookeeper 工具类
 * @author abel
 *
 */
public class ZookeeperUtil {
	private static final Logger log = LoggerFactory.getLogger(ZookeeperUtil.class);
    private static ZooKeeper zk = null;
    
    /**
     *  连接到zookeeper
     * @param zkHost 地址 127.0.0.1:2181
     * @param timeOut 超时时间。 单位:毫秒
     * @throws Exception 
     */
    public static void createConnection(String zkHost, int timeOut) {
        try {
            zk = new ZooKeeper(zkHost, timeOut, new Watcher() {
                // 监控所有被触发的事件
                public void process(WatchedEvent event) {
                    System.out.println("连接成功,已经触发了" + event.getType() + "事件！");
                }
            });
        } catch (IOException e) {
           log.error("zookeeper连接{}时异常,{}",zkHost,e);
        }
    }
    
    /**
     * 关闭连接
     */
    public static boolean closeConnection() {
        try {
            zk.close();
            log.debug("关闭连接");
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 判断当前路径节点是否存在
     * @param nodePath 节点路径
     * @param watch 指定是否复用zookeeper中默认的Watcher。 值： true\false
     * @return Stat为zookeeper的一个对象，如果是空则说明不存在
     */
    public static Stat isExists(String nodePath,boolean watch) {
        Stat stat=null;
        try {
            stat=zk.exists(nodePath, watch);
        } catch (Exception e) {
        	log.error("判断节点{}是否存在异常,{}",nodePath,e);
        }
        return stat;
    }
    
    /**
     *  检测结点是否存在 并设置监听事件  
     * @param path
     * @param watcher  传入指定的三种监听类型： 创建，删除，更新
     * @return
     */
    public Stat exists(String path,Watcher watcher){
    	Stat stat = null;
        try {
            return zk.exists(path,watcher);
        } catch (Exception e) {
            log.error("判断节点{}是否存在异常,{}",path,e);
        }
        return stat;
    }
    
    /**
     * 创建节点和创建子节点的区别在于nodePath 创建节点 nodePath 为 "/nodeFather" 创建其子节点时 nodePath为"/nodeFather/nodeSon"
     *  1.CreateMode 取值   
     *  PERSISTENT：持久化，这个目录节点存储的数据不会丢失 
     *  PERSISTENT_SEQUENTIAL：顺序自动编号的目录节点，这种目录节点会根据当前已近存在的节点数自动加 1，然后返回给客户端已经成功创建的目录节点名； 
     *  EPHEMERAL：临时目录节点，一旦创建这个节点的客户端与服务器端口也就是 session过期超时，这种节点会被自动删除 
     *  EPHEMERAL_SEQUENTIAL：临时自动编号节点 
     * @param nodePath
     * @param nodeData
     */
    public static boolean creatNode(String nodePath, String nodeData) {
    	boolean res = true;
        try {
            zk.create(nodePath, nodeData.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            log.debug("创建节点{}成功，节点内容为：{}",nodePath,nodeData);
        } catch (KeeperException e) {
        	log.error("创建节点{}已经存在{}",nodePath,e);
        	res = false;
        } catch (InterruptedException e) {
        	log.error("节点{}创建失败{}",nodePath,e);
        	res = false;
        }
        return res;
    }
    
    /**
     * 修改持久化节点
     * @param path 可以是子节点也可以是父节点路径
     * @param data 修改后的数据
     */
    public static boolean updateNode(String path, String modifyNodeData){
        try {
            //zk的数据版本是从0开始计数的。如果客户端传入的是-1，则表示zk服务器需要基于最新的数据进行更新。如果对zk的数据节点的更新操作没有原子性要求则可以使用-1.
            //version参数指定要更新的数据的版本, 如果version和真实的版本不同, 更新操作将失败. 指定version为-1则忽略版本检查
            zk.setData(path, modifyNodeData.getBytes(), -1);
            log.debug("更新节点" + path + "的数据为" + modifyNodeData);
            return true;
        } catch (Exception e) {
            log.error("【修改持久化节点异常】{},{},{}",path,modifyNodeData,e);
            return false;
        }
    }
    
    /**
     * 删除持久化节点
     * @param path 删除节点的路径，可以是父节点也可以是子节点
     */
    public static boolean deleteNode(String path){
        try {
            //version参数指定要更新的数据的版本, 如果version和真实的版本不同, 更新操作将失败. 指定version为-1则忽略版本检查
            zk.delete(path,-1);
            log.debug("删除" + path + "节点成功");
            return true;
        } catch (Exception e) {
            log.error("【删除持久化节点异常】{},{}",path,e);
            return false;
        }
    }
    
    /**
     * 获取当前节点的子节点(不包含孙子节点)
     * @param path 父节点path
     */
   public static List<String> getChildren(String path) throws KeeperException, InterruptedException{
	   log.debug("获取节点{}的子节点",path);
       return zk.getChildren(path, false);
   }
   
   /**
    * 获取指定节点的值
    * @param path 节点
    * @param watcher 
    * @param
    * @return
    */
   public static String getNodeData(String nodePath,Watcher watcher){
       try {
           String str = new String(zk.getData(nodePath, watcher, new Stat()));
           log.debug("节点{}内容为{}",nodePath,str);
           return str;
       }catch (Exception e){
    	   log.error("【删除持久化节点异常】{},{}",nodePath,e);
           return "";
       }
   }
   
   /**
    * main测试使用
    * 
    * @param args
    */
   public static void main(String[] args) {
       String nodePath = "/xing";
       String sonNodePath = "/xing/son";
       String zkHost = "localhost:2181";
       int timeOut = 1000;
       try {
           createConnection(zkHost, timeOut);//创建连接
           creatNode(nodePath, "创建了一个节点");//创建节点
           getNodeData(nodePath,null);
           if(isExists(nodePath,true)!=null){
               System.out.println(nodePath+"节点存在");
           }else{
               System.out.println(nodePath+"节点不存在");
           }
           updateNode(nodePath, "我是父节点了，updateNode一下");
           creatNode(sonNodePath, "创建一个子节点");
           getNodeData(sonNodePath,null);
           getChildren(nodePath);
           updateNode(sonNodePath, "我是子节点，updateNode一下");
           deleteNode(sonNodePath);
           deleteNode(nodePath);
           closeConnection();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
    
}