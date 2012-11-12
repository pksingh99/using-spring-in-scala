package org.springframework.scala.demo.scalaconfig

import org.springframework.scala.context.function.FunctionalConfigApplicationContext

object ScalaConfigDriver extends App {

	val applicationContext = new FunctionalConfigApplicationContext(classOf[PersonConfiguration])

	val john = applicationContext.getBean("john", classOf[InitializablePerson])

	println(john)

	println(john.father)
	println(john.mother)

	println(john.initialised)
	applicationContext.close()
	println(john.initialised)


}
