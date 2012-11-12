package org.springframework.scala.demo.collection

import org.springframework.context.support.ClassPathXmlApplicationContext

object CollectionDriver extends App {

	val applicationContext = new ClassPathXmlApplicationContext("collection.xml" , getClass)

	val collection = applicationContext.getBean("scalaCollection", classOf[CollectionBean])

	println("Scala collection: " + collection.scalaSeq)


}
