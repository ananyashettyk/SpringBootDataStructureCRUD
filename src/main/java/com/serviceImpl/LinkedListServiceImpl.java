package com.serviceImpl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.exception.LinkedListException;
import com.model.Node;
import com.repository.LinkedListRepository;
import com.service.LinkedListService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@SuppressWarnings("unused")
public class LinkedListServiceImpl implements LinkedListService {
	private Node head;
	private Node tail;
	private FileOutputStream fout;
	private FileInputStream fin;

	@Autowired
	private LinkedListRepository linkedListRepository;

	LinkedListServiceImpl() {
		this.head = null;
		this.fout = null;
		this.fin = null;
		this.tail = null;
	}

	@Override
	public String addAtTheBiginning(Node x) {
		Node temp = new Node();
		temp.setData(x.getData());
		temp.setNext(head);
		head = temp;

		linkedListRepository.save(temp);
		return "element added";
	}
	
	@Override
	public String addAtTheEnd(Node x) {
		Node temp = new Node();
		temp.setData(x.getData());

		if (head == null) {
			head = temp;
		} else {
			tail.setNext(temp);
		}
		tail = temp;
		linkedListRepository.save(temp);
		return "element added";
	}

	@Override
	public String display() {
		StringBuilder sb = new StringBuilder();
		Node ptr = head;
		log.info("tail----> ");
		while (ptr != null) {
			log.info(ptr.getData() + ",");
			sb.append(ptr.getData()).append(" ");
			ptr = ptr.getNext();
		}
		log.info(" <--- head");
		return sb.toString();
	}

	@Override
	public void writeToFile() {
		try {
			fout = new FileOutputStream("displayList.txt");
			Node ptr = head;
			fout.write(String.valueOf("tail----> ").getBytes());
			while (ptr != null) {
				fout.write(Integer.toString(ptr.getData()).getBytes());
				fout.write(String.valueOf(" ").getBytes());
				ptr = ptr.getNext();
			}
			fout.write(String.valueOf(" <--- head").getBytes());
			fout.close();
			log.info("success...");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	@Override
	public void readFromFile() {
		try {
			fin = new FileInputStream("displayList.txt");
			int i = 0;
			while ((i = fin.read()) != -1) {
				System.out.print((char) i);
			}
			fin.close();
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	@Override
	public void deleteLinkedListElementt(int x) throws LinkedListException {
		if (!(linkedListSearch(x) != null)) {
			throw new LinkedListException("Number is not present in the LinkedList " + x);
		}
		if (linkedListSearch(x) != null) {
			Node prev = null;
			Node ptr = head;
			while (ptr != null) {
				if (ptr.getData() == x)
					break;
				prev = ptr;
				ptr = ptr.getNext();
			}
			if (prev == null) {
				prev = head;
				head = head.getNext();
				prev = null;
			} else {
				prev.setNext(ptr.getNext());
				ptr = null;
			}
		}
	}

	@Override
	public Node linkedListSearch(int x) {
		Node ptr = head;
		while (ptr != null) {
			if (ptr.getData() == x)
				break;
			ptr = ptr.getNext();
		}
		if (ptr == null)
			log.info("Entered number: " + x + " not present");
		else
			log.info("Number is present : " + x);
		return ptr;
	}

	@Override
	public void delFromFront() {
		Node ptr = head;
		Node prev = null;
		while (ptr != null) {
			if (ptr.getNext() != null) {
				prev = ptr;
				ptr = ptr.getNext();
			} else {
				prev.setNext(null);
				break;
			}
		}
	}

	@Override
	public void delFromLast() {
		Node ptr = head;
		head = head.getNext();
		ptr = null;
	}

}
