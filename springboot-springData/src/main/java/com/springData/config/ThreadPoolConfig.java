package com.springData.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 线程池配置
 *
 * Created by conglinliu on 2016/12/6.
 */

@Configuration
public class ThreadPoolConfig {

    @Bean(name = "threadPool")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor threadPool  = new ThreadPoolTaskExecutor();
        threadPool.setCorePoolSize(100);
        threadPool.setMaxPoolSize(2000);
        threadPool.setQueueCapacity(2000);
        threadPool.setKeepAliveSeconds(30);
        threadPool.setAllowCoreThreadTimeOut(true);
        threadPool.setWaitForTasksToCompleteOnShutdown(true);
        return threadPool ;
    }
}
