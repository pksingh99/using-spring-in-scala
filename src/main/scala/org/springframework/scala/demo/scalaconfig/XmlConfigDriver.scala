package org.springframework.scala.demo.scalaconfig

import org.springframework.context.support.ClassPathXmlApplicationContext

object XmlConfigDriver extends App {

	val applicationContext = new ClassPathXmlApplicationContext("person.xml" , getClass)

	val john = applicationContext.getBean("john", classOf[Person])

	println(john)

	println(john.father)
	println(john.mother)


}
