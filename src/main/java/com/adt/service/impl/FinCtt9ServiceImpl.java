package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinCtt9Service;
import com.adt.model.FinCtt9;
import com.adt.dao.FinCtt9Mapper;

@Service
public class FinCtt9ServiceImpl implements FinCtt9Service {
    @Resource
    private FinCtt9Mapper FinCtt9Mapper;

    @Override
    public List<FinCtt9> find(FinCtt9 finCtt9) {
        return this.FinCtt9Mapper.list(finCtt9);
    }

    @Override
    public FinCtt9 view(FinCtt9 finCtt9) {
        return this.FinCtt9Mapper.select(finCtt9);
    }
    
    @Override
    public List<FinCtt9> findAll() {
        return this.FinCtt9Mapper.findAll();
    }

    @Override
    public FinCtt9 findById(String id) {
        return this.FinCtt9Mapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinCtt9 finCtt9) {
        this.FinCtt9Mapper.insert(finCtt9);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinCtt9 finCtt9) {
        this.FinCtt9Mapper.update(finCtt9);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinCtt9 finCtt9) {
        this.FinCtt9Mapper.delete(finCtt9);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinCtt9> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinCtt9>) this.FinCtt9Mapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinCtt9Mapper.selectCount(query);
    }

}
