package com.service;

import org.springframework.stereotype.Service;
import com.exception.LinkedListException;
import com.model.Node;

@Service
public interface LinkedListService { // API - application programming interface

	String addAtTheBiginning(Node x);

	String display();

	void writeToFile();

	void readFromFile();

	void deleteLinkedListElementt(int x) throws LinkedListException;

	Node linkedListSearch(int x);

	void delFromFront();

	void delFromLast();
	public String addAtTheEnd(Node x);

}
