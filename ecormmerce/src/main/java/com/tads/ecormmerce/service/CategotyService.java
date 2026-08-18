package com.tads.ecormmerce.service;
import com.tads.ecormmerce.entity.Category;
import com.tads.ecormmerce.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategotyService {
        @Autowired
        private CategoryRepository repository;

        public List<Category> findAll(){
            List<Category> list = repository.findAll();
            return list;
        }

 }
