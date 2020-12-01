package com.ycw.rabbitmq.workqueues;

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
public class Consumer1 {

    @RabbitListener(queuesToDeclare = @Queue("msg2"))
    public void consume1(String message){
        System.out.println("consumer1收到的信息："+message);
    }


    @RabbitListener(queuesToDeclare = @Queue("msg2"))
    public void consume2(String message){
        System.out.println("consumer2收到的信息："+message);
    }









}
