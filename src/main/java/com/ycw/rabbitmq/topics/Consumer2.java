package com.ycw.rabbitmq.topics;

import com.rabbitmq.client.*;
import com.ycw.utils.RabbitmqConnection;
import lombok.SneakyThrows;

import java.io.IOException;

/**
 * @Author: ychw
 * @Description:
 * @Date: 2020/12/1 12:51
 */
public class Consumer2 {

    @SneakyThrows
    public static void main(String[] args) {
        Connection connection = RabbitmqConnection.getConnection();
        Channel channel = connection.createChannel();

        String exchangeName="logs_1";
//        channel.exchangeDeclare(exchangeName,"topic");
        String queue = channel.queueDeclare().getQueue();
        channel.queueBind(queue,exchangeName,"l.*.*");

        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("Consumer2"+new String(body));
            }
        });



    }
}
