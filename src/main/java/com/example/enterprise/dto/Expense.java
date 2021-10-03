package com.example.enterprise.dto;

import lombok.Data;

import java.util.Date;

public @Data class Expense {
    private String name;
    private int expenseID;
    private double amount;
    private Date dueDate;
    private String category;
    private String note;
}
