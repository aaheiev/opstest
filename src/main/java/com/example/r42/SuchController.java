package com.example.r42;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SuchController {

//	@Value("${suchname}") private String suchName;

	CloseableHttpClient httpClient = HttpClientBuilder.create().build();

	@RequestMapping("/hello")
	public String suchHello() throws IOException {
//		return "hello " + suchName;
		try(CloseableHttpResponse response = httpClient.execute(new HttpGet("http://169.254.169.254/latest/meta-data/placement/availability-zone"))) {
			return EntityUtils.toString(response.getEntity());
		}
	}
	@RequestMapping("/version")
	public String suchVersion() throws IOException {
		return getClass().getPackage().getImplementationVersion();
	}

	@RequestMapping("/")
	public String home() throws IOException {
		return "Home page";
	}
}
