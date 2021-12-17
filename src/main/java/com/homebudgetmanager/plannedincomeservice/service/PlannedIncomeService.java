package com.homebudgetmanager.plannedincomeservice.service;

import com.homebudgetmanager.plannedincomeservice.dao.PlannedIncome;
import com.homebudgetmanager.plannedincomeservice.enums.Month;
import com.homebudgetmanager.plannedincomeservice.interfaces.IPlannedIncomeService;
import com.homebudgetmanager.plannedincomeservice.repository.PlannedIncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PlannedIncomeService implements IPlannedIncomeService {
    @Autowired
    private PlannedIncomeRepository plannedIncomeRepository;

    public List<PlannedIncome> filterPlannedIncomes(Long userId, int year, Optional<String> month, Optional<String> category){

        if (month.isPresent() && category.isPresent()){
            return plannedIncomeRepository.findByUserIdAndMonthAndCategoryAndYear(userId, Month.valueOf(month.get().toUpperCase()), category.get(), year);
        } else if (!month.isPresent() && category.isPresent()){
            return plannedIncomeRepository.findByUserIdAndCategoryAndYear(userId,category.get(), year);
        } else if (month.isPresent() && !category.isPresent()) {
            return plannedIncomeRepository.findByUserIdAndMonthAndYear(userId, Month.valueOf(month.get().toUpperCase()), year);
        } else {
            return plannedIncomeRepository.findByUserIdAndYear(userId, year);
        }
    }

    public void updatePlannedIncomes(Long id, PlannedIncome plannedIncome){
        Optional<PlannedIncome> storedPlannedIncome = plannedIncomeRepository.findById(id);
        if (storedPlannedIncome.isPresent()) {
            storedPlannedIncome.get().setCategory(plannedIncome.getCategory());
            storedPlannedIncome.get().setAmount(plannedIncome.getAmount());

            plannedIncomeRepository.save(storedPlannedIncome.get());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no expense with provided id.");
        }
    }
}
