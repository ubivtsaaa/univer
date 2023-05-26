package com.example.aaa;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    @Autowired
    private Msg_Service service;
    @GetMapping("/messages")
    public List<Messager> list() {
        return service.listAll();
    }

    @GetMapping("/messages/{id}")
    public ResponseEntity<Messager> get(@PathVariable Integer id) {
        try {
            Messager messager = service.get(id);
            return new ResponseEntity<Messager>(messager, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Messager>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/ /{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }


    //    public void add(@RequestBody org_correspondence org_correspondence) {
//        service.save(org_correspondence);
//    }

    // RESTful API methods for Retrieval operations

    // RESTful API method for Create operation

    // RESTful API method for Update operation

    // RESTful API method for Delete operation
}