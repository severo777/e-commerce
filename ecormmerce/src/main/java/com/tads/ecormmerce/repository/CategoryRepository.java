package com.tads.ecormmerce.repository;
import com.tads.ecormmerce.entity.Category;
import  org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category,Long> {
}
