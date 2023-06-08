package com.example.jfopdracht.dao;

import com.example.jfopdracht.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonDAO extends CrudRepository<Person, Integer> {
}
