package com.kittycoder.alert;

import com.kittycoder.domain.Spittle;
import org.springframework.jms.core.JmsOperations;

/**
 * Created by shucheng on 2020/7/27 16:00
 */
public class AlertServiceImpl implements AlertService {

    private JmsOperations jmsOperations;

    public AlertServiceImpl(JmsOperations jmsOperations) {
        this.jmsOperations = jmsOperations;
    }

    @Override
    public void sendSpittleAlert(Spittle spittle) {
        // 写法一：
        /*jmsOperations.send("spittle.alert.queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(spittle);
            }
        });*/
        // 写法二：
        // jmsOperations里配置了defaultDestinationName时，就可以不传destinationName
        /*jmsOperations.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(spittle);
            }
        });*/
        // 写法三：
        jmsOperations.convertAndSend(spittle);
    }

    @Override
    public Spittle retrieveSpittleAlert() {
        // 写法一：
        /*try {
            ObjectMessage receivedMessage = (ObjectMessage) jmsOperations.receive("spittle.alert.queue");
            return (Spittle) receivedMessage.getObject();
        } catch (JMSException e) {
            throw JmsUtils.convertJmsAccessException(e);
        }*/
        // 写法二：
        // jmsOperations里配置了defaultDestinationName时，就可以不传destinationName
        /*try {
            ObjectMessage receivedMessage = (ObjectMessage) jmsOperations.receive();
            return (Spittle) receivedMessage.getObject();
        } catch (JMSException e) {
            throw JmsUtils.convertJmsAccessException(e);
        }*/
        // 写法三：
        return (Spittle) jmsOperations.receiveAndConvert();
    }
}
