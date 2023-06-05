package com.example.jfopdracht.dao;

import com.example.jfopdracht.entities.product;
import org.springframework.data.repository.CrudRepository;

public interface productDAO extends CrudRepository<product, Integer> {
}
