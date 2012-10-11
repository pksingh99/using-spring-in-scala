package org.springframework.scala.demo.beans

import scala.reflect.BeanProperty

class BeanPropertyScalaBean {

	@BeanProperty
	var readWrite: String = _

}
