package com.example.spring_boot_new.repo;


import com.example.spring_boot_new.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Integer> {
    boolean existsByCode(int code);
}
