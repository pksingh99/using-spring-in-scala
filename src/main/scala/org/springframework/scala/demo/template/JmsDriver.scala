package org.springframework.scala.demo.template

import javax.jms.TextMessage
import org.apache.activemq.ActiveMQConnectionFactory
import org.springframework.jms.connection.CachingConnectionFactory

object JmsDriver extends App {

	val connectionFactory = new CachingConnectionFactory(
					new ActiveMQConnectionFactory("vm://localhost?broker.persistent=false"))

	val javaTemplate = new org.springframework.jms.core.JmsTemplate(connectionFactory)
	javaTemplate.setDefaultDestinationName("queue")
	javaTemplate.setReceiveTimeout(1000)

	val scalaTemplate = new org.springframework.scala.jms.core.JmsTemplate(javaTemplate)

	scalaTemplate.send() {
	  _.createTextMessage("Hello World")
	}

	scalaTemplate.receive("queue") match {
		case Some(textMessage: TextMessage) => println("Message received: " + textMessage.getText)
		case None => println("No text message received")
	}

}
