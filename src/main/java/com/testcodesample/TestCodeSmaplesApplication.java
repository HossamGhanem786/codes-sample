package com.testcodesample;

import java.io.File;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@SpringBootApplication
public class TestCodeSmaplesApplication {

	public static void main(String[] args) {
		// testCurlLogin();
		// testCurlGetMinutes();
		testCurlRecognizeFile();
		//testCurlRecognizeLink();
		// SpringApplication.run(TestCodeSmaplesApplication.class, args);
	}

	static void testCurlLogin() {

		try {
			HttpResponse<String> response = Unirest.post(
					"https://test.rdi-kateb.com:8090/api/login?email=hossam.ghanem786%40gmail.com&apiKey=959de3c9cbd14ffe951ce7d701fb6b27")
					.asString();
			System.out.println(response.getBody());
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void testCurlGetMinutes() {
		try {
			HttpResponse<String> response = Unirest.get("https://test.rdi-kateb.com:8090/api/getMinutes")
					.header("content-type", "application/json")
					.header("authorization",
							"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJob3NzYW0uZ2hhbmVtNzg2QGdtYWlsLmNvbSIsImp0aSI6IjUwMDRmODMzLTg4MjMtNDJkZS1iNzk1LWU0ZTlkNDEyYjQxYiIsImNsaWVudF9pZCI6ImthdGViLWNsaWVudCIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSIsInRydXN0Il19.dqY8DUvF1XO8RtVqZtRIp-nQ4cmA8MuKRnMQNfmbUUk")
					.asString();
			System.out.println(response.getBody());

		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void testCurlRecognizeFile() {
		try {
			String filePath="/var/tmp/hello.mp4";
			
			HttpResponse<String> response = Unirest.post("https://test.rdi-kateb.com:8090/api/recognize-file")
					.header("content-type", "multipart/form-data")
					.header("authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJob3NzYW0uZ2hhbmVtNzg2QGdtYWlsLmNvbSIsImp0aSI6IjUwMDRmODMzLTg4MjMtNDJkZS1iNzk1LWU0ZTlkNDEyYjQxYiIsImNsaWVudF9pZCI6ImthdGViLWNsaWVudCIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSIsInRydXN0Il19.dqY8DUvF1XO8RtVqZtRIp-nQ4cmA8MuKRnMQNfmbUUk")
					.field("File", new File(filePath)).asString();
			System.out.println(response.getBody());
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	static void testCurlRecognizeLink() {
		try {
			HttpResponse<String> response = Unirest.post("https://test.rdi-kateb.com:8090/api/recognize-link?link=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3D6iOYQ1Zi6qE%26t%3D2s&start=0f&end=0f&languageCode=EG")
				  .header("authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJob3NzYW0uZ2hhbmVtNzg2QGdtYWlsLmNvbSIsImp0aSI6IjUwMDRmODMzLTg4MjMtNDJkZS1iNzk1LWU0ZTlkNDEyYjQxYiIsImNsaWVudF9pZCI6ImthdGViLWNsaWVudCIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSIsInRydXN0Il19.dqY8DUvF1XO8RtVqZtRIp-nQ4cmA8MuKRnMQNfmbUUk")
				  .asString();
		System.out.println(response.getBody());
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
