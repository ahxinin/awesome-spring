package com.ahxinin.awesomespring;

import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author : hexin
 * @description: Github查找用户服务
 * @date : 2021-07-25
 */
@Service
public class GitHubLookupService {

    private static final Logger logger = LoggerFactory.getLogger(GitHubLookupService.class);

    private final RestTemplate restTemplate;

    public GitHubLookupService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Async
    public CompletableFuture<User> findUser(String user) throws InterruptedException {
        logger.info("find user:{}", user);
        String url = String.format("https://api.github.com/users/%s",user);
        User result = restTemplate.getForObject(url,User.class);
        Thread.sleep(10000L);
        return CompletableFuture.completedFuture(result);
    }
}
