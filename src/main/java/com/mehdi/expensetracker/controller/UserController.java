package com.mehdi.expensetracker.controller;

import com.mehdi.expensetracker.model.Expense;
import com.mehdi.expensetracker.model.User;
import com.mehdi.expensetracker.service.ExpenseService;
import com.mehdi.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService us;

    @Autowired
    ExpenseService es;

    @PostMapping(value = "/create")
    public User createUser(@RequestBody User user){
        return us.createUser(user);
    }

    @GetMapping(value = "/getAll")
    public List<User> getAllUsers(){
        return us.findAllUsers();
    }

    @GetMapping(value = "/get/{id}")
    public User getUserById(@PathVariable int id){
        return us.findUserById(id);
    }

    @PutMapping(value = "/edit/{id}")
    public User editUserById(@PathVariable int id, @RequestBody User user){
        return us.editUserById(id, user);
    }

    @DeleteMapping(value = "/delete/{id}")
    public User deleteById(@PathVariable int id){
        return us.deleteUserById(id);
    }

    @PutMapping(value = "/addExpense/{id}")
    public User addExpense(@PathVariable int id, @RequestBody Expense expense){
        return us.addExpenseToUserById(id,expense);
    }

    @PutMapping(value = "/changeSolde/{id}/{solde}")
    public User changeSolde(@PathVariable int id, @PathVariable double solde){
        return us.enterSoldeById(id, solde);
    }
}
