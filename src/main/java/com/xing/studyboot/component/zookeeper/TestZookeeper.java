package com.xing.studyboot.component.zookeeper;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

/**
 *  java 使用原生API连接Zookeeper
 *  此处已经更改为组件启动，可查看 ZookeeperConfig 相同得代码
 * @author xing
 * @createTime
 */
public class TestZookeeper {

	public static void main(String[] args) {
		try {
	        final CountDownLatch countDownLatch=new CountDownLatch(1);
	        @SuppressWarnings("resource")
			ZooKeeper zooKeeper=
	            new ZooKeeper("172.23.8.168:2181",4000, new Watcher() {
	                @Override
	                public void process(WatchedEvent event) {
	                    if(Event.KeeperState.SyncConnected==event.getState()){
	                        //如果收到了服务端的响应事件，连接成功
	                        countDownLatch.countDown();
	                    }
	                }
	            });
	        countDownLatch.await();
	        //CONNECTED
	        System.out.println(zooKeeper.getState());
	        zooKeeper.create("/myNode","0".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
	    }catch (Exception e) {
			e.printStackTrace();
		}
	}
}
