package cn.itcast.mq;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumerApplication {

    //启动报错可能是rabbitmq中没有queue信息 需要生产者先发送消息
    //也可也直接注册bean回调创建队列
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }


    //jdk本身的序列化方法性能较差而且有安全风险
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
