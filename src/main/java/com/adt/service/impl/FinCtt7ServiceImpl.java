package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinCtt7Service;
import com.adt.model.FinCtt7;
import com.adt.dao.FinCtt7Mapper;

@Service
public class FinCtt7ServiceImpl implements FinCtt7Service {
    @Resource
    private FinCtt7Mapper FinCtt7Mapper;

    @Override
    public List<FinCtt7> find(FinCtt7 finCtt7) {
        return this.FinCtt7Mapper.list(finCtt7);
    }

    @Override
    public FinCtt7 view(FinCtt7 finCtt7) {
        return this.FinCtt7Mapper.select(finCtt7);
    }
    
    @Override
    public List<FinCtt7> findAll() {
        return this.FinCtt7Mapper.findAll();
    }

    @Override
    public FinCtt7 findById(String id) {
        return this.FinCtt7Mapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinCtt7 finCtt7) {
        this.FinCtt7Mapper.insert(finCtt7);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinCtt7 finCtt7) {
        this.FinCtt7Mapper.update(finCtt7);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinCtt7 finCtt7) {
        this.FinCtt7Mapper.delete(finCtt7);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinCtt7> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinCtt7>) this.FinCtt7Mapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinCtt7Mapper.selectCount(query);
    }

}
