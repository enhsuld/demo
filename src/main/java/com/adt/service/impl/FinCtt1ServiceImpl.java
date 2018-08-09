package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinCtt1Service;
import com.adt.model.FinCtt1;
import com.adt.dao.FinCtt1Mapper;

@Service
public class FinCtt1ServiceImpl implements FinCtt1Service {
    @Resource
    private FinCtt1Mapper FinCtt1Mapper;

    @Override
    public List<FinCtt1> find(FinCtt1 finCtt1) {
        return this.FinCtt1Mapper.list(finCtt1);
    }

    @Override
    public FinCtt1 view(FinCtt1 finCtt1) {
        return this.FinCtt1Mapper.select(finCtt1);
    }
    
    @Override
    public List<FinCtt1> findAll() {
        return this.FinCtt1Mapper.findAll();
    }

    @Override
    public FinCtt1 findById(String id) {
        return this.FinCtt1Mapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinCtt1 finCtt1) {
        this.FinCtt1Mapper.insert(finCtt1);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinCtt1 finCtt1) {
        this.FinCtt1Mapper.update(finCtt1);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinCtt1 finCtt1) {
        this.FinCtt1Mapper.delete(finCtt1);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinCtt1> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinCtt1>) this.FinCtt1Mapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinCtt1Mapper.selectCount(query);
    }

}
