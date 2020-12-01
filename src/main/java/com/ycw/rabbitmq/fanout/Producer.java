package com.ycw.rabbitmq.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.ycw.utils.RabbitmqConnection;
import lombok.SneakyThrows;

/**
 * 扇出，广播，发布/订阅
 * @Author: ychw
 * @Description:
 * @Date: 2020/12/1 12:40
 */
public class Producer {
    @SneakyThrows
    public static void main(String[] args) {
        Connection connection = RabbitmqConnection.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("registry","fanout");

        for(int i=0;i<10;i++){
            channel.basicPublish("registry","",null,(i+"：广播消息").getBytes());
        }

        RabbitmqConnection.closeConnection(connection,channel);
        System.out.println("completed");


    }
}
