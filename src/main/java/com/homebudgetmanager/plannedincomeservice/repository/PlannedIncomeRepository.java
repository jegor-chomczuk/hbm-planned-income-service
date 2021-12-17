package com.homebudgetmanager.plannedincomeservice.repository;

import com.homebudgetmanager.plannedincomeservice.dao.PlannedIncome;
import com.homebudgetmanager.plannedincomeservice.enums.Month;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlannedIncomeRepository extends JpaRepository<PlannedIncome, Long> {
    void deleteByUserId(Long id);
    void deleteByCategory(String category);
    List<PlannedIncome> findByUserIdAndMonthAndCategoryAndYear(Long userId, Month month, String category, int year);
    List<PlannedIncome> findByUserIdAndCategoryAndYear(Long userId, String category, int year);
    List<PlannedIncome> findByUserIdAndMonthAndYear(Long userId, Month month, int year);
    List<PlannedIncome> findByUserIdAndYear(Long userId, int year);
}
