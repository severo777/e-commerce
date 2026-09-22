package com.tads.ecormmerce.service;

import com.tads.ecormmerce.dto.CategoryDTO;
import com.tads.ecormmerce.entity.Category;
import com.tads.ecormmerce.repository.CategoryRepository;


import com.tads.ecormmerce.service.exception.ResourceNotFoundException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@Service
public class CategoryService {
        @Autowired
        private CategoryRepository repository;
@Transactional
        public List<CategoryDTO> findAll(){
            List<Category> list = repository.findAll();
            List<CategoryDTO> listDTO = list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
            return listDTO;
        }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        Category entity = obj.orElseThrow (()-> new ResourceNotFoundException("Entity not Found!-"));

        return new CategoryDTO(entity);
    }
 }
