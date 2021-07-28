package com.jay.springboot.dao;

import com.jay.springboot.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category,Integer>{

}
