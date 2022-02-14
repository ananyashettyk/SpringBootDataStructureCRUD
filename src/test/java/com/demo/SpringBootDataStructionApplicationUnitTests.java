package com.demo;

import java.util.Random;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import org.springframework.test.web.servlet.MockMvc;

import com.model.Node;
import com.repository.LinkedListRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@WebMvcTest // for unit testing
@AutoConfigureMockMvc
//@TestMethodOrder(MethodOrderer.class)
class SpringBootDataStructionApplicationUnitTests {
	private Random random = new Random();

	@LocalServerPort
	private int port;

//	@Autowired
//	MockMvc mockMvc; // to directly call the api's

	@MockBean
	LinkedListRepository linkedlistRepository;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
//	@Order(1)
	public void shouldAddatTheBegeningOfTheLinkedList() {
		random.setSeed(2);
		for (int i = 0; i < 5; i++) {
			Node node1 = new Node();
			node1.setData(4 + random.nextInt());

			ResponseEntity<String> linkedlistAddResponseAtBeginning = restTemplate.postForEntity(
					"http://localhost:" + port + "/datastructures/LinkedlistAddBeginning", node1, String.class);
			System.out.println(linkedlistAddResponseAtBeginning.getBody());
		}
	}
	
//	@Test
//	public void shouldAddAtTheEnd() {
//		random.setSeed(4);
//		for (int i = 0; i < 5; i++) {
//			Node node1 = new Node();
//			node1.setData(4 + random.nextInt());
//
//			ResponseEntity<String> linkedlistAddResponseAtEnd = restTemplate.postForEntity(
//					"http://localhost:" + port + "/datastructures/linkedListAddEnd", node1, String.class);
//			System.out.println(linkedlistAddResponseAtEnd.getBody());
//		}
//	}
	
	@Test
//	@Order(2)
	public void shouldDisplayLinkedList() {
		shouldAddatTheBegeningOfTheLinkedList();
		ResponseEntity<String> linkedListDisplayResponse = restTemplate
				.getForEntity("/datastructures/displayLinkedList", String.class);
		System.out.println(linkedListDisplayResponse.getBody());
		
//		shouldAddAtTheEnd();
//		ResponseEntity<String> linkedListDisplayResponse1 = restTemplate
//				.getForEntity("/datastructures/displayLinkedList", String.class);
//		System.out.println(linkedListDisplayResponse1.getBody());
	}

	@Test
//	@Order(3)
	public void shouldSearchLinkedList() {
		Node node2 = new Node();
		node2.setData(4);
		
		ResponseEntity<String> linkedlistAddResponseAtBeginning = restTemplate.postForEntity(
				"http://localhost:" + port + "/datastructures/LinkedlistAddBeginning", node2, String.class);
		
		Node node3 = new Node();
		node3.setData(6);
		
		ResponseEntity<String> linkedlistAddResponseAtBeginning1 = restTemplate.postForEntity(
				"http://localhost:" + port + "/datastructures/LinkedlistAddBeginning", node3, String.class);
		
		ResponseEntity<String> linkedListSearchResponse = restTemplate.postForEntity("/datastructures/searchLinkedList",
				node2, String.class);
		System.out.println(linkedListSearchResponse.getBody());
		ResponseEntity<String> linkedListSearchResponse1 = restTemplate.postForEntity("/datastructures/searchLinkedList",
				node3, String.class);
		System.out.println(linkedListSearchResponse1.getBody());
		
	}

	@Test
	public void shouldDeleteFromLinkedList() {
		Node node2 = new Node();
		node2.setData(4);
		
		ResponseEntity<String> linkedlistAddResponseAtBeginning = restTemplate.postForEntity(
				"http://localhost:" + port + "/datastructures/LinkedlistAddBeginning", node2, String.class);
		
		Node node3 = new Node();
		node3.setData(6);
		
		ResponseEntity<String> linkedlistAddResponseAtBeginning1 = restTemplate.postForEntity(
				"http://localhost:" + port + "/datastructures/LinkedlistAddBeginning", node3, String.class);
		
		ResponseEntity<String> linkedListDeleteResponse = restTemplate.postForEntity("/datastructures/deleteLinkedListElement",
				node3, String.class);
		System.out.println(linkedListDeleteResponse.getBody());
	}

	@Test
	void contextLoads() {

	}

}
