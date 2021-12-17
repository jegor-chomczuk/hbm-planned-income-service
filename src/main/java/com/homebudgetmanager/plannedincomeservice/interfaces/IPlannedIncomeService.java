package com.homebudgetmanager.plannedincomeservice.interfaces;

import com.homebudgetmanager.plannedincomeservice.dao.PlannedIncome;

import java.util.List;
import java.util.Optional;

public interface IPlannedIncomeService {
    List<PlannedIncome> filterPlannedIncomes(Long userId, int year, Optional<String> month, Optional<String> category);
    void updatePlannedIncomes(Long id, PlannedIncome plannedIncome);
}
