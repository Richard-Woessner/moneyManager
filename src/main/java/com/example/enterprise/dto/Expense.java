package com.example.enterprise.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public @Data class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int expenseID;
    private String name;
    private double amount;
    private String dueDate;
    private String category;
    private String note;
}
