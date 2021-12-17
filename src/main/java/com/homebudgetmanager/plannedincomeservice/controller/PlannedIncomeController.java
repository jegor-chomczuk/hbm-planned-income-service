package com.homebudgetmanager.plannedincomeservice.controller;

import com.homebudgetmanager.plannedincomeservice.dao.PlannedIncome;
import com.homebudgetmanager.plannedincomeservice.interfaces.IPlannedIncomeService;
import com.homebudgetmanager.plannedincomeservice.repository.PlannedIncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "*")
//@Transactional
@RestController
@RequestMapping("/planned-income/")
public class PlannedIncomeController {
    @Autowired
    private PlannedIncomeRepository plannedIncomeRepository;
    @Autowired
    private IPlannedIncomeService plannedIncomeService;

    // GET Methods
    //  http://localhost:8500/planned-income/all
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<PlannedIncome> getAllPlannedIncome() {
        return plannedIncomeRepository.findAll();
    }

    //  http://localhost:8500/planned-income/id/1
    @GetMapping("id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<PlannedIncome> getPlannedIncomeById(@PathVariable Long id) {
        return plannedIncomeRepository.findById(id);
    }

    //  http://localhost:8500/planned-income/user-id/1/year/2021
    //  http://localhost:8500/planned-income/user-id/1/year/2021/?month=january
    //  http://localhost:8500/planned-income/user-id/1/year/2021/?category=Debt repayment
    //  http://localhost:8500/planned-income/user-id/1/year/2021/?month=january&category=Debt repayment
    @GetMapping("user-id/{userId}/year/{year}")
    @ResponseStatus(HttpStatus.OK)
    public List<PlannedIncome> getFilteredPlannedIncomes(@PathVariable Long userId, @PathVariable int year, @RequestParam Optional<String> month, @RequestParam Optional<String> category) {
        return plannedIncomeService.filterPlannedIncomes(userId, year, month, category);
    }

    //  DELETE Methods
    //  http://localhost:8500/planned-income/delete/id/1
    @DeleteMapping("delete/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlannedIncomeById(@PathVariable Long id){
        plannedIncomeRepository.deleteById(id);
    }

    //  http://localhost:8500/planned-income/delete/user-id/1
    @DeleteMapping("delete/user-id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlannedIncomeByUserId(@PathVariable Long id){
        plannedIncomeRepository.deleteByUserId(id);
    }

    //  http://localhost:8500/planned-income/delete/category/Debt repayment
    @DeleteMapping("delete/category/{category}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlannedIncomesByCategory(@PathVariable String category){
        plannedIncomeRepository.deleteByCategory(category);
    }

    //  POST Method
    //  http://localhost:8500/planned-income/add
    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPlannedIncome(@RequestBody PlannedIncome plannedIncome){
        plannedIncomeRepository.save(plannedIncome);
    }

    //  PUT Method
    //  http://localhost:8500/planned-income/update/id/1
    @PutMapping("update/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePlannedIncome(@PathVariable(name="id") Long id, @RequestBody PlannedIncome plannedIncome){
        plannedIncomeService.updatePlannedIncomes(id, plannedIncome);
    }
}
