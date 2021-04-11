package com.danutsrl.testare.service;


import com.danutsrl.testare.entity.Task;
import com.danutsrl.testare.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;


    public Task saveTask(Task task) {
        return repository.save(task);
    }

    public List<Task> saveTask(List<Task> task) {
        return repository.saveAll(task);
    }

    public List<Task> getTask() {
        return repository.findAll();
    }

    public Task getTaskById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Task getTaskByTitle(String title) {
        return repository.findByTitle(title);
    }

    public String deleteTask(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }


}
