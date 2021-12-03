package com.example.enterprise;

import com.example.enterprise.dto.Expense;
import com.example.enterprise.dto.Income;
import com.example.enterprise.service.IExpenseService;
import com.example.enterprise.service.IIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
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
        double avgInc = 0.0;

        for (int i = 0; i < incomeList.size(); i++) {
            avgInc += incomeService.calcIncAverage(incomeList.get(i));
        }

        //Get totals
        double incomeTotal = incomeService.getTotal();
        double expenseTotal = expenseService.getTotal();
        model.addAttribute("incomeTotal",incomeTotal);
        model.addAttribute("expenseTotal",expenseTotal);
        model.addAttribute("avgInc", avgInc);
        model.addAttribute("overallTotal",(avgInc - expenseTotal));


        return "index";
    }


    /**
     * Directs to all-income page with income records from the DB
     */
    @RequestMapping("/all-income")
    public String allIncome(Model model){
        List<Income> incomeList = incomeService.listAll();
        model.addAttribute(incomeList);
        double avgInc = 0.0;

        for (int i = 0; i < incomeList.size(); i++) {
            avgInc += incomeService.calcIncAverage(incomeList.get(i));
        }
        double incomeTotal = incomeService.getTotal();
        model.addAttribute("avgInc", avgInc);
        return "all-income";
    }

    /**
     * Directs to all-expenses page with expense records from the DB
     */
    @RequestMapping("/all-expenses")
    public String allExpenses(Model model){
        List<Expense> expenseList = expenseService.listAll();
        model.addAttribute(expenseList);
        return "all-expenses";
    }


    /**
     * Directs user to privacy page
     */
    @RequestMapping("/privacy")
    public String privacy(){
        return "privacy";
    }


    /**
     * Directs user to terms page
     */
    @RequestMapping("/terms")
    public String terms(){
        return "terms";
    }





    /**
     * Takes user defined income object from the index and inserts it into the DB
     * Redirects to the / endpoint
     */
    @RequestMapping("/addIncomeEntry")
    public String addIncomeEntry(Income newIncomeEntry, Model model) throws Exception {
        System.out.println(newIncomeEntry.toString());
        incomeService.save(newIncomeEntry);
        return "redirect:/";
    }
    /**
     * Takes user defined expense object from the index and inserts it into the DB
     * Redirects to the / endpoint
     */
    @RequestMapping("/addExpenseEntry")
    public String addExpenseEntry(Expense newExpenseEntry){
        System.out.println(newExpenseEntry.toString());
        expenseService.save(newExpenseEntry);
        return "redirect:/";
    }




    /**
     * Takes altered Income object from edit.html, and updates the Income record in the DB
     */
    @RequestMapping("/updateIncomeEntry")
    public String updateIncomeEntry(Income income){
        incomeService.updateIncome(income);
        return "redirect:/";
    }

    /**
     * Takes altered Expense object from edit.html, and updates the Expense record in the DB
     */
    @RequestMapping("/updateExpenseEntry")
    public String updateExpenseEntry(Expense expense){
        expenseService.updateExpense(expense);
        System.out.println(expenseService.searchByID(expense.getExpenseID()));
        return "redirect:/";
    }



    /**
     * Returns JSON file of all Expense Records from DB
     */
    @GetMapping("/expense")
    @ResponseBody
    public List<Expense> fetchAllExpenses() {
        List<Expense> list = expenseService.showAll();
        System.out.println(list);
        return list;
    }
    /**
     * Returns JSON file of all Income Records from DB
     */
    @GetMapping("/income")
    @ResponseBody
    public List<Income> fetchAllIncome() {
        List<Income> list = incomeService.listAll();
        System.out.println(list);
        return list;
    }

    /**
     * Returns a String of a Income record with the id given by the URL
     */
    @GetMapping("/income/{id}/")
    @ResponseBody
    public String fetchIncomeById(@PathVariable("id") int id) {

        return incomeService.searchByID(id).toString();

    }

    /**
     * Takes the id and Object type from index
     * then returns to the edit page with the object from the db
     */
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

    /**
     * Takes the id and Object type from the edit page
     * Deletes the record from the DB with the given id
     */
    @RequestMapping("/delete")
    public String deleteById(Model model,
                           @RequestParam(value="id") int id,
                           @RequestParam(value="type") String valueType) {

        if(valueType.equals("income")){
            incomeService.deleteByID(id);
            return "redirect:/";
        }
        else if(valueType.equals("expense")){
            expenseService.deleteByID(id);
            return "redirect:/";
        }
        else{
            return "redirect:/";
        }
    }

}
