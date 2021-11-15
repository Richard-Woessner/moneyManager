package com.example.enterprise;

import com.example.enterprise.dto.Expense;
import com.example.enterprise.dto.Income;
import com.example.enterprise.service.IExpenseService;
import com.example.enterprise.service.IIncomeService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MoneyManagerController {

    @Autowired
    IIncomeService incomeService;
    @Autowired
    IExpenseService expenseService;

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
    public String addIncomeEntry(Income newIncomeEntry) throws Exception {
        System.out.println(newIncomeEntry.toString());
        incomeService.save(newIncomeEntry);
        return "index";
    }
    @RequestMapping("/addExpenseEntry")
    public String addExpenseEntry(Expense newExpenseEntry){
        System.out.println(newExpenseEntry.toString());
        expenseService.save(newExpenseEntry);
        return "index";
    }

    @GetMapping("/income")
    @ResponseBody
    public List<Income> fetchAllIncome() {
        List<Income> list = incomeService.listAll();
        System.out.println(list);
        return list;
//        List<Income> allIncome = incomeService.listAll();
//        Map<String, List> map = new HashMap<String, List>();
//        System.out.println(allIncome);
//        return map;
    }

    @GetMapping("/income/{id}/")
    public ResponseEntity fetchIncomeById(@PathVariable("id") String id) {
        return new ResponseEntity(HttpStatus.OK);

    }

//    @PostMapping(value="/income", consumes = "application/json", produces = "application/json")
//    public String addIncome(@RequestBody Income income){
//        String json = new Gson().toJson(incomeService.listAll());
//        System.out.println(json);
//        return json;
//    }

}
