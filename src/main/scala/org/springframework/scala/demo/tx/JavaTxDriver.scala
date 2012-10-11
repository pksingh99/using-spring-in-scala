package org.springframework.scala.demo.tx

import org.springframework.transaction.support.{TransactionCallback, TransactionTemplate}
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.TransactionStatus

object JavaTxDriver extends App {

	val db = new EmbeddedDatabaseBuilder().addDefaultScripts().build()

	val jdbcTemplate = new SimpleJdbcTemplate(db)

	val transactionManager = new DataSourceTransactionManager(db)

	val txTemplate = new TransactionTemplate(transactionManager)

	implicit def functionToTxCallback[T](function: TransactionStatus => T) =
		new TransactionCallback[T] {
			def doInTransaction(status: TransactionStatus) = function(status)
		}

	val result1 = txTemplate.execute((status: TransactionStatus) => {
		jdbcTemplate.queryForObject("SELECT FIRST_NAME FROM USERS WHERE ID = 1", classOf[String])
	})

	println(result1)


}
