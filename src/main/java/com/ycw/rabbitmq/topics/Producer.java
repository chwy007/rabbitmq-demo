package com.ycw.rabbitmq.topics;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.ycw.utils.RabbitmqConnection;
import lombok.SneakyThrows;

/**
 * 动态路由 通配符
 * @Author: ychw
 * @Description:
 * @Date: 2020/12/1 12:40
 */
public class Producer {
    @SneakyThrows
    public static void main(String[] args) {
        Connection connection = RabbitmqConnection.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("logs_1","topic");
        String routingKey="l.user.save";
        String exchangeName="logs_1";
        for(int i=0;i<10;i++){
            channel.basicPublish(exchangeName,routingKey,null,("：日志路由消息:"+routingKey).getBytes());
        }

        RabbitmqConnection.closeConnection(connection,channel);
        System.out.println("completed");


    }
}
