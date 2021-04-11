package com.danutsrl.testare.controllers;


import com.danutsrl.testare.entity.Task;
import com.danutsrl.testare.entity.Users;
import com.danutsrl.testare.service.TaskService;
import com.danutsrl.testare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    TaskService taskService;
    @Autowired
    UserService userService;

    @RequestMapping("/tasks")
    public String TaskPage(Model model) {

        List<Task> taskList = taskService.getTask();

        model.addAttribute("taskList", taskList);

        return "task_page";
    }

    @RequestMapping("/newtask")
    public String showNewTaskForm(Model model){
        Task task = new Task();
        List <Users> usersList = userService.getUsers();
        model.addAttribute("task",task);
        model.addAttribute("usersList",usersList);
        return "task_page_add";
    }
    @RequestMapping(value = "/savetask", method = RequestMethod.POST)
    public String saveTask(@ModelAttribute("task") @Valid Task task, Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("task",task);
            return "task_page_add";
        }
        taskService.saveTask(task);

        return "redirect:/tasks";
    }

    @RequestMapping("/edit/task/{id}")
    public String showEditTaskPage(@PathVariable(name = "id") int id, Model model) {

        Task task = taskService.getTaskById(id);
        model.addAttribute("task",task);

        List <Users> usersList = userService.getUsers();


        model.addAttribute("usersList",usersList);

        return "task_page_add";
    }
    @RequestMapping("/delete/task/{id}")
    public String deleteTask(@PathVariable(name = "id") int id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
