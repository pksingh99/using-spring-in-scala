package org.springframework.scala.demo.tx

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.scala.transaction.support.TransactionManagement

object ScalaTxDriver extends App with TransactionManagement {

	val db = new EmbeddedDatabaseBuilder().addDefaultScripts().build()

	val jdbcTemplate = new SimpleJdbcTemplate(db)

	val transactionManager = new DataSourceTransactionManager(db)

	val result1: String = transactional() {
		                                      status => {
			                                      jdbcTemplate.queryForObject(
				                                      "SELECT FIRST_NAME FROM USERS WHERE ID = 1",
				                                      classOf[String])
		                                      }
	                                      }

	println(result1)


}
