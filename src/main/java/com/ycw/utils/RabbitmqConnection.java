package com.ycw.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: ychw
 * @Description:
 * @Date: 2020/11/30 21:12
 */
public class RabbitmqConnection {

    private static ConnectionFactory connectionFactory;

    static {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.1.120");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/myvirtual");
        connectionFactory.setUsername("ycw");
        connectionFactory.setPassword("ycw");
    }

    public static Connection getConnection(){


        try {

            Connection connection = connectionFactory.newConnection();
            return connection;
        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public static void closeConnection(Connection conn, Channel channel){
        {
            try {
                if(channel!=null)  channel.close();
                if(conn!=null)  conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
