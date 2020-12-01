package com.ycw.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;

/**
 * @Author: ychw
 * @Description:
 * @Date: 2020/12/1 19:19
 */
@Component
public class Consumer2 {

    @RabbitListener(bindings =
        @QueueBinding(
                value = @Queue,
                exchange = @Exchange(value = "logs",type = "fanout")))
    public void consume1(String message){
        System.out.println("consumer1收到的信息："+message);

    }


    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "logs",type = "fanout")))
    public void consume2(String message){
        System.out.println("consumer2收到的信息："+message);
    }









}
