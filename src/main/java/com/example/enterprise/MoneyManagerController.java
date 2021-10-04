package com.example.enterprise;

import com.example.enterprise.dto.Expense;
import com.example.enterprise.dto.Income;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MoneyManagerController {

    /**
     * Handle the / endpoint
     * @return the landing page
     */
    @RequestMapping("/")
    public String index(Model model){
        Expense expense = new Expense();
        Income income = new Income();
        model.addAttribute(income);
        model.addAttribute(expense);
        return "index";
    }

    @RequestMapping("/privacy")
    public String privacy(){
        return "privacy";
    }

    @RequestMapping("/terms")
    public String terms(){
        return "terms";
    }

    @RequestMapping("/addIncomeEntry")
    public String addIncomeEntry(Income newIncomeEntry){
        return "index";
    }

    @GetMapping("/income")
    public ResponseEntity fetchAllIncome() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/income/{id}/")
    public ResponseEntity fetchIncomeById(@PathVariable("id") String id) {
        return new ResponseEntity(HttpStatus.OK);

    }

    @PostMapping(value="/income", consumes = "application/json", produces = "application/json")
    public Income addIncome(@RequestBody Income income){
        return income;
    }

}
