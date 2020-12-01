package com.ycw.rabbitmq.topics;

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
public class Consumer4 {

    @RabbitListener(bindings =
        @QueueBinding(
                value = @Queue,
                exchange = @Exchange(value = "logs-2",type = "topic"),
                key = {"user.*","product.*","*.item.*"}
        ))
    public void consume1(String message){
        System.out.println("consumer1收到的信息："+message);

    }


    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "logs-2",type = "topic"),
            key = {"user.#","product.#"}
    ))
    public void consume2(String message){
        System.out.println("consumer2收到的信息："+message);
    }









}
