package com.AddressBookApp.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitmqConfig {
    @Bean
    public Queue contactQueue() {
        return new Queue("contactQueue", true);
    }
    @Bean
    public Queue passwordQueue() {
        return new Queue("passwordQueue", true);
    }
    @Bean
    public Queue loginQueue() {
        return new Queue("loginQueue", true);
    }
    @Bean
    public Queue userQueue() {
        return new Queue("userQueue", true);
    }
}