package com.danutsrl.testare.service;


import com.danutsrl.testare.entity.Task;
import com.danutsrl.testare.entity.Users;
import com.danutsrl.testare.repository.TaskRepository;
import com.danutsrl.testare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;





    public Users saveUser(Users user)
        {



        return repository.save(user);
    }

    public List<Users> saveUsers(List<Users> users) {

        return repository.saveAll(users);
    }

    public List<Users> getUsers() {
        return repository.findAll();
    }

    public Users getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Users getUserByName(String name) {
        return repository.findByUsername(name);
    }

    public String deleteUser(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }


}