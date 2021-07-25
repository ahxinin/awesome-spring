package com.ahxinin.awesomespring;

import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author : hexin
 * @description: 启动时运行任务
 * @date : 2021-07-25
 */
@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    @Autowired
    private GitHubLookupService gitHubLookupService;

    @Override
    public void run(String... args) throws Exception {
        long start = System.currentTimeMillis();

        CompletableFuture<User> user1 = gitHubLookupService.findUser("PivotalSoftware");
        CompletableFuture<User> user2 = gitHubLookupService.findUser("CloudFoundry");
        CompletableFuture<User> user3 = gitHubLookupService.findUser("Spring-Projects");

        CompletableFuture.allOf(user1, user2 ,user3).join();

        logger.info("cost time:{}", (System.currentTimeMillis()-start));
        logger.info("user1:{}",user1.get().getName());
        logger.info("user2:{}",user2.get().getName());
        logger.info("user3:{}",user3.get().getName());
    }
}
