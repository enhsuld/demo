package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinBudgetService;
import com.adt.model.FinBudget;
import com.adt.dao.FinBudgetMapper;

@Service
public class FinBudgetServiceImpl implements FinBudgetService {
    @Resource
    private FinBudgetMapper FinBudgetMapper;

    @Override
    public List<FinBudget> find(FinBudget finBudget) {
        return this.FinBudgetMapper.list(finBudget);
    }

    @Override
    public FinBudget view(FinBudget finBudget) {
        return this.FinBudgetMapper.select(finBudget);
    }
    
    @Override
    public List<FinBudget> findAll() {
        return this.FinBudgetMapper.findAll();
    }

    @Override
    public FinBudget findById(String id) {
        return this.FinBudgetMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinBudget finBudget) {
        this.FinBudgetMapper.insert(finBudget);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinBudget finBudget) {
        this.FinBudgetMapper.update(finBudget);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinBudget finBudget) {
        this.FinBudgetMapper.delete(finBudget);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinBudget> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinBudget>) this.FinBudgetMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinBudgetMapper.selectCount(query);
    }

}
