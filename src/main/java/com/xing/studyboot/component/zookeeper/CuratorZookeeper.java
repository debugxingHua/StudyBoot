//package com.xing.studyboot.component.zookeeper;
//
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.CuratorFrameworkFactory;
//import org.apache.curator.retry.ExponentialBackoffRetry;
//import org.apache.zookeeper.data.Stat;
//
//public class CuratorZookeeper {
//	public static void main(String[] args) throws Exception {
//		CuratorFramework curatorFramework=CuratorFrameworkFactory.
//                builder().connectString("172.23.8.168:2181").
//                sessionTimeoutMs(4000).
//                retryPolicy(new ExponentialBackoffRetry(1000,3)).
//                namespace("").build();
//        curatorFramework.start();
//        Stat stat=new Stat();
//        //查询节点数据
//        byte[] bytes = curatorFramework.getData().storingStatIn(stat).forPath("/myNode");
//        System.out.println("节点"+new String(bytes));
//        curatorFramework.close();
//	}
//}
