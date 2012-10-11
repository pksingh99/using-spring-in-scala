package org.springframework.scala.demo.template

import org.springframework.scala.web.client.RestTemplate
import org.springframework.http.client.{ClientHttpRequest, ClientHttpResponse}
import org.springframework.http.HttpMethod

object ScalaTemplateDriver extends App {

	val template = new RestTemplate()

	val result1 = template.getForAny[String]("http://example.com")

	println(result1.foreach(_.substring(0, 10)))

	val result2 = template.execute("http://example.com", HttpMethod.GET)
	{
    (request: ClientHttpRequest) => {}
  }
	{
    (response: ClientHttpResponse) => {
       val buf = new Array[Byte](10)
       response.getBody.read(buf)
       Option(new String(buf, "UTF-8"))}
  }

	println(result2)


}
