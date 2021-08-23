package com.xing.studyboot.config.redis;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  配置一个简单的缓存，指定缓存位置
 * @author xing
 * @createTime
 */
@Configuration
public class CacheManagerConfig {
	@Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("sampleCacheTest")));
        cacheManager.afterPropertiesSet();
        return cacheManager;
    }
}
