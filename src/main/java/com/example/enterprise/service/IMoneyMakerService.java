package com.example.enterprise.service;

import com.example.enterprise.dto.Income;

public interface IMoneyMakerService {

    Income fetchById(int id);
}
