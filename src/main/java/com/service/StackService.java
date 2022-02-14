package com.service;

import org.springframework.stereotype.Service;

import com.model.Node;

@Service
public interface StackService {

	String pushToStack(Node x);

//	void pushStack(int x);

	void popStack();

	void displayStack();
}
