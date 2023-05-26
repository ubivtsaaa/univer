package com.example.aaa;
import com.example.aaa.Messager;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;


public interface m_repo extends JpaRepository<Messager, Integer> {
    public List<Messager> findAll();
    public List<Messager> save();
    public List<Messager> findById();
    public List<Messager> deleteById();



}

