package org.springframework.scala.demo.scalaconfig

class Person(val firstName: String, val lastName: String) {

	var father: Person = null
	var mother: Person = null

	override def toString = firstName + " " + lastName
}
