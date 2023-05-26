package com.example.aaa;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.JpaRepository;
@Service
@Transactional

public class Msg_Service {

    @Autowired
    private Messager repo;

    public List<Messager> listAll() {

        return repo.findAll();
    }

    public void save(Messager messager) {

        repo.save(messager);
    }

    public Messager get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}