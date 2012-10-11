package org.springframework.scala.demo.collection

import org.springframework.context.support.ClassPathXmlApplicationContext

object CollectionDriver extends App {

	val applicationContext = new ClassPathXmlApplicationContext("collection.xml" , getClass)

	val javaCollection = applicationContext.getBean("javaCollection", classOf[JavaCollectionBean])

	println("Java collection: " + javaCollection.scalaSeq)

	val scalaCollection = applicationContext.getBean("scalaCollection", classOf[ScalaCollectionBean])

	println("Scala collection: " + scalaCollection.scalaSeq)


}
