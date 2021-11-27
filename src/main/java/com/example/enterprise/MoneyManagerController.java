package com.example.enterprise;

import com.example.enterprise.dto.Expense;
import com.example.enterprise.dto.Income;
import com.example.enterprise.service.IExpenseService;
import com.example.enterprise.service.IIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

        //ADD DATABASE ENTRIES
        List<Income> incomeList = incomeService.listAll();
        model.addAttribute(incomeList);
        List<Expense> expenseList = expenseService.showAll();
        model.addAttribute(expenseList);

        //Get totals
        double incomeTotal = incomeService.getTotal();
        double expenseTotal = expenseService.getTotal();
        model.addAttribute("incomeTotal",incomeTotal);
        model.addAttribute("expenseTotal",expenseTotal);
        model.addAttribute("overallTotal",(incomeTotal - expenseTotal));


        return "index";
    }

    @RequestMapping("/all-income")
    public String allIncome(Model model){
        List<Income> incomeList = incomeService.listAll();
        model.addAttribute(incomeList);
        return "all-income";
    }
    @RequestMapping("/all-expenses")
    public String allExpenses(Model model){
        List<Expense> expenseList = expenseService.listAll();
        model.addAttribute(expenseList);
        return "all-expenses";
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
    public String addIncomeEntry(Income newIncomeEntry, Model model) throws Exception {
        System.out.println(newIncomeEntry.toString());
        incomeService.save(newIncomeEntry);
        return "redirect:/";
    }
    @RequestMapping("/updateIncomeEntry")
    public String updateIncomeEntry(Income income){
        incomeService.updateIncome(income);
        return "redirect:/";
    }
    @RequestMapping("/addExpenseEntry")
    public String addExpenseEntry(Expense newExpenseEntry){
        System.out.println(newExpenseEntry.toString());
        expenseService.save(newExpenseEntry);
        return "redirect:/";
    }
    @RequestMapping("/updateExpenseEntry")
    public String updateExpenseEntry(Expense expense){
        expenseService.updateExpense(expense);
        System.out.println(expenseService.searchByID(expense.getExpenseID()));
        return "redirect:/";
    }

    @GetMapping("/expense")
    @ResponseBody
    public List<Expense> fetchAllExpenses() {
        List<Expense> list = expenseService.showAll();
        System.out.println(list);
        return list;
    }

    @GetMapping("/income")
    @ResponseBody
    public List<Income> fetchAllIncome() {
        List<Income> list = incomeService.listAll();
        System.out.println(list);
        return list;
    }

    @GetMapping("/income/{id}/")
    public ResponseEntity fetchIncomeById(@PathVariable("id") String id) {
        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping("/edit")
    public String editById(Model model,
                           @RequestParam(value="id") int id,
                           @RequestParam(value="type") String valueType) {


        if(valueType.equals("income")){

            Income income = incomeService.searchByID(id);
            System.out.println(income.toString());
            model.addAttribute(income);
            return "edit";
        }
        else if(valueType.equals("expense")){
            Expense expense = expenseService.searchByID(id);
            System.out.println(expense.toString());
            model.addAttribute(expense);
            return "edit";
        }
        else{
            return "redirect:/";
        }

    }

}
