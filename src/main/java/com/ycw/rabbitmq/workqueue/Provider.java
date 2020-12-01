package com.ycw.rabbitmq.workqueue;

import com.rabbitmq.client.*;
import com.ycw.utils.RabbitmqConnection;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: ychw
 * @Description:
 * @Date: 2020/11/30 19:44
 */
public class Provider {


    @Test
    public void test01() throws IOException, TimeoutException {
        Connection connection = RabbitmqConnection.getConnection();


        Channel channel = connection.createChannel();
        //参数2 队列持久化
        //参数3 独占队列
        channel.queueDeclare("secret1",true,false,false,null);
        for (int i=0;i<20;i++){
            channel.basicPublish("","secret1", MessageProperties.PERSISTENT_TEXT_PLAIN,(i+":hello rabbitmq112").getBytes());

        }

        RabbitmqConnection.closeConnection(connection,channel);
        System.out.println("over");


    }

}
