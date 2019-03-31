package com.mehdi.expensetracker.controller;

import com.mehdi.expensetracker.model.Expense;
import com.mehdi.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {

    @Autowired
    ExpenseService es;

    @PostMapping(value = "/create")
    public Expense createExpense(@RequestBody Expense expense){
        return es.createExpense(expense);
    }

    @GetMapping(value = "/getAll")
    public List<Expense> getAllExpenses(){
        return es.findAllExpenses();
    }

    @GetMapping(value = "/get/{id}")
    public Expense getExpenseById(@PathVariable int id){
        return es.findExpenseById(id);
    }

    @GetMapping(value = "/getByUser/{id}")
    public List<Expense> getExpensesByUserId(@PathVariable int id){
        return es.findExpensesByUserId(id);
    }

    @PutMapping(value = "/edit/{id}")
    public Expense editExpenseById(@PathVariable int id, @RequestBody Expense expense){
        return es.editExpenseById(id, expense);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Expense deleteById(@PathVariable int id){
        return es.deleteExpenseById(id);
    }

}
