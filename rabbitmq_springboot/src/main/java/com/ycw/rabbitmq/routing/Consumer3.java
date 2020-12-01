package com.ycw.rabbitmq.routing;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: ychw
 * @Description:
 * @Date: 2020/12/1 19:19
 */
@Component
public class Consumer3 {

    @RabbitListener(bindings =
        @QueueBinding(
                value = @Queue,
                exchange = @Exchange(value = "logs-1",type = "direct"),
                key = {"info","error"}
        ))
    public void consume1(String message){
        System.out.println("consumer1收到的info,error信息："+message);

    }


    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "logs-1",type = "direct"),
            key = {"error"}
    ))
    public void consume2(String message){
        System.out.println("consumer2收到的error信息："+message);
    }









}
