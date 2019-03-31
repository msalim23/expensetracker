package com.mehdi.expensetracker.service;

import com.mehdi.expensetracker.model.Expense;
import com.mehdi.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository er;

    public Expense createExpense(Expense expense){
        er.save(expense);
        return expense;
    }

    public Expense findExpenseById(int id){
        return er.findById(id).get();
    }

    public List<Expense> findAllExpenses(){
        return er.findAll();
    }

    public Expense editExpenseById(int id, Expense expense){
        Expense toEdit = er.findById(id).get();

        toEdit.setName(expense.getName());
        toEdit.setAmount(expense.getAmount());
        toEdit.setDescription(expense.getDescription());

        er.save(toEdit);

        return toEdit;

    }


    public Expense deleteExpenseById(int id){
        Expense expense = er.findById(id).get();
        er.delete(expense);
        return expense;
    }

    public List<Expense> findExpensesByUserId(int id){
        return er.findExpensesByUserId(id);
    }
}
