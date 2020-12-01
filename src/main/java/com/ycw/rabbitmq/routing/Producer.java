package com.ycw.rabbitmq.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.ycw.utils.RabbitmqConnection;
import lombok.SneakyThrows;

/**
 * 路由
 * @Author: ychw
 * @Description:
 * @Date: 2020/12/1 12:40
 */
public class Producer {
    @SneakyThrows
    public static void main(String[] args) {
        Connection connection = RabbitmqConnection.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("logs","direct");
        String routingKey="info";
        String exchangeName="logs";
        for(int i=0;i<10;i++){
            channel.basicPublish(exchangeName,routingKey,null,(i+"：日志路由消息:"+routingKey).getBytes());
        }

        RabbitmqConnection.closeConnection(connection,channel);
        System.out.println("completed");


    }
}
