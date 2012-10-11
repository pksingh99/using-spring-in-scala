package org.springframework.scala.demo.collection

import scala.collection.JavaConverters._

class JavaCollectionBean(javaList: java.util.List[String]) {

	val scalaSeq: Seq[String] = javaList.asScala

}
