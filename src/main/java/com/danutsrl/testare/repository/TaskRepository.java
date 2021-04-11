package com.danutsrl.testare.repository;


import com.danutsrl.testare.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    Task findByTitle(String title);
}
