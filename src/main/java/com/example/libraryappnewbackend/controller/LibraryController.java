package com.example.libraryappnewbackend.controller;

import com.example.libraryappnewbackend.dao.BooksDao;
import com.example.libraryappnewbackend.dao.UserDao;
import com.example.libraryappnewbackend.model.Books;
import com.example.libraryappnewbackend.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    private BooksDao bdao;

    @Autowired
    private UserDao udao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/useradd", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> AddUser(@RequestBody Users u){
        udao.save(u);
        HashMap <String, String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/bookadd", consumes = "application/json", produces = "application/json")
    public HashMap<String, String>  AddBooks(@RequestBody Books b){
        bdao.save(b);
        HashMap <String, String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewbooks")
    public List<Books> ViewBooks(){
        return (List<Books>) bdao.findAll();
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public List<Users> Login(@RequestBody Users u){
        return (List<Users>) udao.LoginCheck(u.getUsername(),u.getPassword());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search", consumes = "application/json", produces = "application/json")
    public List<Books> SearchBooks(@RequestBody Books b){
        return (List<Books>) bdao.SearchBooks(b.getBookName());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete", consumes = "application/json", produces = "application/json")
    public HashMap<String, String>  DeleteBooks(@RequestBody Books b){
        bdao.DeleteBook(b.getId());
        HashMap <String, String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

}
