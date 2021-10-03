package com.example.enterprise.dto;

import lombok.Data;

import java.util.Date;

public @Data class Income {
    private String source;
    private int incomeID;
    private double amount;
    private int frequency;
    private Date depositDate;
    private String note;
}
