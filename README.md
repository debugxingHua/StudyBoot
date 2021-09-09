# StudyBoot
系统学习下SpringBoot的练手项目


启动注意事项：
1.activaMQ默认连接本地，监听qqq队列，需要配置一个队列或在com.xing.studyboot.message下的Consumer里注释掉@Component关掉
2.zookeeper连接在com.xing.studyboot.config.zookeeper.ZookeeperConfig里注释掉@Component关掉
3.定时任务Quartz在com.xing.studyboot.time.config.QuartzConfig里注释掉//@Configuration关闭
4.定时任务开启Spring Task在启动类com.xing.studyboot.StudybootApplication注释掉//@EnableScheduling关闭


