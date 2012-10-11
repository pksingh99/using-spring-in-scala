package org.springframework.scala.demo.beans

import org.springframework.context.support.ClassPathXmlApplicationContext

object BeansDriver extends App {

	val applicationContext = new ClassPathXmlApplicationContext("beans.xml" , getClass)

	val constructor = applicationContext.getBean("constructor", classOf[ConstructorScalaBean])

	println("Constructor injection: " + constructor.readOnly + " " + constructor.readWrite)

	val beanProperty = applicationContext.getBean("beanProperty", classOf[BeanPropertyScalaBean])

	println("@BeanProperty injection: " + beanProperty.readWrite)

	val scalaBean = applicationContext.getBean("scalaBean", classOf[ScalaBean])

	println("Setter injection: " + scalaBean.readWrite)


}
