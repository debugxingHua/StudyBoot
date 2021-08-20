//package com.xing.studyboot.database.config;
//
//import java.util.Map;
//
//import javax.persistence.EntityManager;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef="xhEntityManager",
//        transactionManagerRef="xhTransactionManager",
//        basePackages= { "com.xing.studyboot.database.h2.repository.xh" }) //设置Repository所在位置
//public class XHRepositoryConfig {
//
//	@Autowired @Qualifier("xhDS")
//    private DataSource xhDataSource;
//
//    @Primary
//    @Bean(name = "xhEntityManager")
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
//        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
//    }
//
//    @Primary
//    @Bean(name = "entityManagerFactoryPrimary")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary (EntityManagerFactoryBuilder builder) {
//        return builder
//                .dataSource(xhDataSource)
////                .properties(getVendorProperties(xhDataSource))
//                .packages("com.didispace.domain.p") //设置实体类所在位置
//                .persistenceUnit("primaryPersistenceUnit")
//                .build();
//    }
//
////    @Autowired
////    private JpaProperties jpaProperties;
////    private Map<String, String> getVendorProperties(DataSource dataSource) {
////        return jpaProperties.getHibernateProperties(dataSource);
////    }
//
//    @Primary
//    @Bean(name = "xhTransactionManager")
//    public PlatformTransactionManager xhTransactionManager(EntityManagerFactoryBuilder builder) {
//        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
//
//    }
//}
