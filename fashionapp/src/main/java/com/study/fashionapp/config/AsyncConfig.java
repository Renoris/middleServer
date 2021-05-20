package com.study.fashionapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync //비동기 기능 활성화
public class AsyncConfig extends AsyncConfigurerSupport {
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor(); //비동기로 호출하는 스레드에 대한 설정
        executor.setCorePoolSize(2); //기본적으로 실행을 대기하는 Thread의 갯수
        executor.setMaxPoolSize(5); //동시 동작하는 스레드의 최대 갯수
        executor.setQueueCapacity(500); //동시동작하는 스레드의 갯수가 최대갯수를 초과시 그 요청을 저장하는 큐-초과시 에러
        executor.setThreadNamePrefix("clothingApplication-async-"); //spring이 생성하는 쓰레드의 접두사\
        executor.initialize();
        return executor;
    }
}
