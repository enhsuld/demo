package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinBudget;


public interface FinBudgetService {
    public List<FinBudget> find(FinBudget finBudget);
    public FinBudget view(FinBudget finBudget);
    public void add(FinBudget finBudget);
    public void edit(FinBudget finBudget);
    public void remove(FinBudget finBudget);
    public List<FinBudget> findAll();
    public FinBudget findById(String id);
    
    public List<FinBudget> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
