//package com.demo;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.SpringBootDataStructionApplication;
//																//for Integration testing
//@SpringBootTest(	
//		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
//		classes = SpringBootDataStructionApplication.class
//		)	
//@AutoConfigureMockMvc
//@TestPropertySource()		//(locations = "--application-test.properties") <- path
//class DemoApplicationIntegrationTests {
//
//	@Autowired
//	MockMvc mockMvc; // to directly call the api's
//	
//	@Test
//	void contextLoads() throws Exception {
//		
//		MvcResult mvcResult = mockMvc
//				.perform(MockMvcRequestBuilders.get("/datastructures")
//						.accept(MediaType.APPLICATION_JSON)
//			).andReturn();
//		
//		System.out.println(mvcResult.getResponse());
//		
//	}
//
//}
