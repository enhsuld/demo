package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinTgt1Service;
import com.adt.model.FinTgt1;
import com.adt.dao.FinTgt1Mapper;

@Service
public class FinTgt1ServiceImpl implements FinTgt1Service {
    @Resource
    private FinTgt1Mapper FinTgt1Mapper;

    @Override
    public List<FinTgt1> find(FinTgt1 finTgt1) {
        return this.FinTgt1Mapper.list(finTgt1);
    }

    @Override
    public FinTgt1 view(FinTgt1 finTgt1) {
        return this.FinTgt1Mapper.select(finTgt1);
    }
    
    @Override
    public List<FinTgt1> findAll() {
        return this.FinTgt1Mapper.findAll();
    }

    @Override
    public FinTgt1 findById(String id) {
        return this.FinTgt1Mapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinTgt1 finTgt1) {
        this.FinTgt1Mapper.insert(finTgt1);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinTgt1 finTgt1) {
        this.FinTgt1Mapper.update(finTgt1);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinTgt1 finTgt1) {
        this.FinTgt1Mapper.delete(finTgt1);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinTgt1> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinTgt1>) this.FinTgt1Mapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinTgt1Mapper.selectCount(query);
    }

}
