package com.homebudgetmanager.plannedincomeservice;

import com.homebudgetmanager.plannedincomeservice.dao.PlannedIncome;
import com.homebudgetmanager.plannedincomeservice.enums.Month;
import com.homebudgetmanager.plannedincomeservice.repository.PlannedIncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Data {
    @Autowired
    private PlannedIncomeRepository plannedIncomeRepository;

    public void populate() {
//        plannedIncomeRepository.save(new PlannedIncome("Salary", 10.00, Month.JANUARY, 2021, 1l));
//        plannedIncomeRepository.save(new PlannedIncome("Partner's salary", 11.00, Month.MARCH, 2021, 1l));
//        plannedIncomeRepository.save(new PlannedIncome("Bonus", 12.00, Month.JANUARY, 2021, 1l));
//        plannedIncomeRepository.save(new PlannedIncome("Interest", 13.00, Month.JANUARY, 2022, 2l));
//        plannedIncomeRepository.save(new PlannedIncome("Dividends", 14.00, Month.FEBRUARY, 2021, 1l));
//        plannedIncomeRepository.save(new PlannedIncome("Sales", 15.00, Month.FEBRUARY, 2021, 1l));
//        plannedIncomeRepository.save(new PlannedIncome("Tax refund", 16.00, Month.FEBRUARY, 2022, 2l));
    }
}
