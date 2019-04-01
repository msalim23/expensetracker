package com.mehdi.expensetracker.service;

import com.mehdi.expensetracker.model.Expense;
import com.mehdi.expensetracker.model.User;
import com.mehdi.expensetracker.repository.ExpenseRepository;
import com.mehdi.expensetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository ur;

    @Autowired
    ExpenseRepository er;

    public User createUser(User user){
        ur.save(user);
        return user;
    }

    public User findUserById(int id){
        return ur.findById(id).get();
    }

    public List<User> findAllUsers(){
        return ur.findAll();
    }

    public User editUserById(int id, User user){
        User toEdit = ur.findById(id).get();

        toEdit.setLogin(user.getLogin());
        toEdit.setPassword(user.getPassword());
        toEdit.setNom(user.getNom());
        toEdit.setPrenom(user.getPrenom());
        toEdit.setEmail(user.getEmail());

        ur.save(toEdit);

        return toEdit;

    }

    public User addExpenseToUserById(int id, Expense expense){
        User user = ur.findById(id).get();
        expense.setUser(user);
        er.save(expense);
        user.addExpense(expense);
        ur.save(user);
        return user;
    }

    public User deleteUserById(int id){
        User user = ur.findById(id).get();
        ur.delete(user);
        return user;
    }

    public User enterSoldeById(int id, double solde){

        User user = ur.findById(id).get();
        user.setSolde(solde);
        ur.save(user);
        return user;
    }
}
