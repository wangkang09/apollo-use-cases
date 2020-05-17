package com.ctrip.framevowrk.apollo.use.cases.agent;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

/**
 * @author: kl @kailing.pub
 * @date: 2019/5/8
 */
@SpringBootApplication
@EnableApolloConfig
public class Application implements CommandLineRunner{

    @Value("${test.input:777}")
    private String input;

    @Override
    public void run(String... args) {
        Config config = ConfigService.getAppConfig();
        for (String key : config.getPropertyNames()) {
            System.out.println(key);
            System.out.println(config.getProperty(key,"default"));
        }

        while (true){
            System.err.println(input);
            try {
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e){
               e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
