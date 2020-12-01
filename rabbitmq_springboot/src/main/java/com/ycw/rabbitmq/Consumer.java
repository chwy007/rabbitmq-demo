package com.ycw.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: ychw
 * @Description:
 * @Date: 2020/12/1 19:19
 */
@Component
@RabbitListener(queuesToDeclare=@Queue(value = "msg1",durable = "true",exclusive = "false",autoDelete = "ture"))
public class Consumer {

    @RabbitHandler
    public void handle(String message){
        System.out.println("收到的信息："+message);
    }










}
