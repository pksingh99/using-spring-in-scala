package org.springframework.scala.demo.scalaconfig

import org.springframework.scala.context.function.FunctionalConfiguration

class PersonConfiguration extends FunctionalConfiguration {
	val jack = bean("jack") {
    new Person("Jack", "Doe")
	}

	val jane = bean("jane") {
    new Person("Jane", "Doe")
	}

	val john = bean("john") {
    val john = new InitializablePerson("John", "Doe")
		john.father = jack()
		john.mother = jane()
		john
	} init {
		_.initialize()
	} destroy {
		_.destroy()
	}
}
