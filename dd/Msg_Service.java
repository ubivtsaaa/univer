package com.example.aaa;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
@Service
@Transactional

public class Msg_Service {

    @Autowired
    private JpaRepository<Messanger, Integer> repo;

    public List<Messanger> listAll() {

        return repo.findAll();
    }

    public void save(Messanger messanger) {

        repo.save(messanger);
    }

    public Messanger get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}