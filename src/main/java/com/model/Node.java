package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
@Entity(name = "Node")
public class Node implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


	@Transient
	private Node next;
	
	private int data;

	public Node(Integer id, int data, Node next) {
		this.id = id;
		this.data = data;
		this.next = next;
	}
	
	public Node() {
		this.data = 0;
		this.next = null;
	}
	

}
