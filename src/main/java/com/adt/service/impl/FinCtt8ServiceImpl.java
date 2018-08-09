package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinCtt8Service;
import com.adt.model.FinCtt8;
import com.adt.dao.FinCtt8Mapper;

@Service
public class FinCtt8ServiceImpl implements FinCtt8Service {
    @Resource
    private FinCtt8Mapper FinCtt8Mapper;

    @Override
    public List<FinCtt8> find(FinCtt8 finCtt8) {
        return this.FinCtt8Mapper.list(finCtt8);
    }

    @Override
    public FinCtt8 view(FinCtt8 finCtt8) {
        return this.FinCtt8Mapper.select(finCtt8);
    }
    
    @Override
    public List<FinCtt8> findAll() {
        return this.FinCtt8Mapper.findAll();
    }

    @Override
    public FinCtt8 findById(String id) {
        return this.FinCtt8Mapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinCtt8 finCtt8) {
        this.FinCtt8Mapper.insert(finCtt8);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinCtt8 finCtt8) {
        this.FinCtt8Mapper.update(finCtt8);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinCtt8 finCtt8) {
        this.FinCtt8Mapper.delete(finCtt8);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinCtt8> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinCtt8>) this.FinCtt8Mapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinCtt8Mapper.selectCount(query);
    }

}
