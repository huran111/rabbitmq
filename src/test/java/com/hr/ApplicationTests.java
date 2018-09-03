package com.hr;

import com.hr.entity.Order;
import com.hr.producer.Send;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    Send send;

    @Test
    public void send() throws Exception {
        Order order = new Order();
        order.setId("20180903");
        order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
        order.setName("胡冉");
        send.sendOrder(order);
    }
}
