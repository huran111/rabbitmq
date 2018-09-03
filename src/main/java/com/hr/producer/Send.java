package com.hr.producer;

import com.hr.entity.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huran
 * @Title: Send
 * @ProjectName rabbitmq-demo
 * @Description: 发送消息
 * @date 2018/9/311:21
 */
@Component
public class Send {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOrder(Order order) throws Exception {
        CorrelationData correlation = new CorrelationData();
        correlation.setId(order.getMessageId());
        rabbitTemplate.convertAndSend("order-exchange", "order.abcd", order, correlation);
    }
}
