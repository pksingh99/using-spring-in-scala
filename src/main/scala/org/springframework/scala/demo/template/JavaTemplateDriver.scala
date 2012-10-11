package org.springframework.scala.demo.template

import org.springframework.web.client.{ResponseExtractor, RestTemplate}
import org.springframework.http.HttpMethod
import org.springframework.http.client.ClientHttpResponse

object JavaTemplateDriver extends App {

	val template = new RestTemplate()

	val result1: String = template.getForObject("http://example.com", classOf[String])

	println(result1.substring(0, 10))

	implicit def functionToResponseExtractor[T](function: ClientHttpResponse => T) =
		new ResponseExtractor[T] {
			def extractData(response: ClientHttpResponse) = function(response)
		}

	val result2: String = template.execute("http://example.com",
	                                       HttpMethod.GET,
	                                       null,
	                                       (response: ClientHttpResponse) => {
		                                       val buf = new Array[Byte](10)
		                                       response.getBody.read(buf)
		                                       new String(buf, "UTF-8")
	                                       })

	println(result2)


}
