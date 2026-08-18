package com.tads.ecormmerce.resource;


import com.tads.ecormmerce.entity.Category;
import com.tads.ecormmerce.service.CategotyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

        @Controller
        @RequestMapping ( value = "/categories")
    public class CategoryResource {
            @Autowired
            private CategotyService service;

            @GetMapping
            public ResponseEntity <List<Category>> findAll () {
              List<Category> list = service.findAll();

              return ResponseEntity.ok((list));

            }

        }