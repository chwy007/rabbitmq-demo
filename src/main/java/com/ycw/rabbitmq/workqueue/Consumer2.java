package com.ycw.rabbitmq.workqueue;

import com.rabbitmq.client.*;
import com.ycw.utils.RabbitmqConnection;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 直连 点对点
 * @Author: ychw
 * @Description:
 * @Date: 2020/11/30 20:39
 */
public class Consumer2 {

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = RabbitmqConnection.getConnection();


        Channel channel = connection.createChannel();

        channel.basicQos(1);
        channel.basicConsume("secret1",false,new DefaultConsumer(channel){
            @SneakyThrows
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("Consumer2获取的消息："+new String(body));
                Thread.sleep(10);
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });






    }

}
