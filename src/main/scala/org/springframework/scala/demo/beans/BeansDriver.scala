package org.springframework.scala.demo.beans

import org.springframework.context.support.ClassPathXmlApplicationContext

object BeansDriver extends App {

	val applicationContext = new ClassPathXmlApplicationContext("beans.xml" , getClass)
	val constructor = applicationContext.getBean("constructor", classOf[ConstructorBean])

	println(constructor.foo)

	val setter = applicationContext.getBean("setter", classOf[SetterBean])

	println(setter.foo)
}
