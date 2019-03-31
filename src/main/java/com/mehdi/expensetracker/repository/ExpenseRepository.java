package com.mehdi.expensetracker.repository;

import com.mehdi.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    List<Expense> findExpensesByUserId(int id);
}
