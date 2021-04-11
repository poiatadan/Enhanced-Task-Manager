package com.danutsrl.testare.controllers;

import com.danutsrl.testare.entity.Users;
import com.danutsrl.testare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UsersController {
    @Autowired
    UserService service;


    @RequestMapping("/testusers")
    public String HomePage(Model model) {
        List<Users> usersList = service.getUsers();
        model.addAttribute("usersList", usersList);
        return "users_page";
    }
    @RequestMapping("/newuser")
    public String showNewUserForm(Model model){
        Users users = new Users();
        model.addAttribute("users",users);
        return "users_form";
    }
    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute ("users") @Valid Users users, Errors errors,Model model) {
        if(errors.hasErrors()){
            model.addAttribute("users",users);
            return "users_form";
        }
        service.saveUser(users);

        return "redirect:/testusers";
    }
    @RequestMapping("/edit/user/{id}")
    public String showEditUserPage(@PathVariable("id") int id, Model model) {
        Users users = service.getUserById(id);
        model.addAttribute("users",users);

        return "users_form";
    }
    @RequestMapping("/delete/user/{id}")
    public String deleteUser(@PathVariable(name = "id") int id) {
        service.deleteUser(id);
        return "redirect:/testusers";
    }


}

