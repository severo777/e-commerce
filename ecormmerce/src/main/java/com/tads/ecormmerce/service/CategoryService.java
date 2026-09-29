package com.tads.ecormmerce.service;

import com.tads.ecormmerce.dto.CategoryDTO;
import com.tads.ecormmerce.entity.Category;
import com.tads.ecormmerce.repository.CategoryRepository;


import com.tads.ecormmerce.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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
    @Transactional(readOnly = true)
    public CategoryDTO insert(CategoryDTO dto) {
    Category entity = new Category();
    entity.setName(dto.getName());

    entity = repository.save(entity);
    return new CategoryDTO(entity);
    }

    public CategoryDTO update(long id, CategoryDTO dto) {
        try {
            Category entity = repository.getReferenceById(id);
            entity.setName(dto.getName());
            entity = repository.save(entity);
            return new CategoryDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("id not found!-"+id);
        }

    }
}

