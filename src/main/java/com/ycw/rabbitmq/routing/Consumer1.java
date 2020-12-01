package com.ycw.rabbitmq.routing;

import com.rabbitmq.client.*;
import com.ycw.utils.RabbitmqConnection;
import lombok.SneakyThrows;

import java.io.IOException;

/**
 * @Author: ychw
 * @Description:
 * @Date: 2020/12/1 12:51
 */
public class Consumer1 {

    @SneakyThrows
    public static void main(String[] args) {
        Connection connection = RabbitmqConnection.getConnection();
        Channel channel = connection.createChannel();

        String queue = channel.queueDeclare().getQueue();
        String exchangeName="logs";
        channel.queueBind(queue,exchangeName,"error");

        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("Consumer1"+new String(body));
            }
        });



    }
}
