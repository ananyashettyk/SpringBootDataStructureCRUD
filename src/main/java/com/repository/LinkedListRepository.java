package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.model.Node;

@Repository
public interface LinkedListRepository extends CrudRepository<Node, Integer> {

}
