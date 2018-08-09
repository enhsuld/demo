package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinNt2Service;
import com.adt.model.FinNt2;
import com.adt.dao.FinNt2Mapper;

@Service
public class FinNt2ServiceImpl implements FinNt2Service {
    @Resource
    private FinNt2Mapper FinNt2Mapper;

    @Override
    public List<FinNt2> find(FinNt2 finNt2) {
        return this.FinNt2Mapper.list(finNt2);
    }

    @Override
    public FinNt2 view(FinNt2 finNt2) {
        return this.FinNt2Mapper.select(finNt2);
    }
    
    @Override
    public List<FinNt2> findAll() {
        return this.FinNt2Mapper.findAll();
    }

    @Override
    public FinNt2 findById(String id) {
        return this.FinNt2Mapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinNt2 finNt2) {
        this.FinNt2Mapper.insert(finNt2);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinNt2 finNt2) {
        this.FinNt2Mapper.update(finNt2);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinNt2 finNt2) {
        this.FinNt2Mapper.delete(finNt2);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinNt2> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinNt2>) this.FinNt2Mapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinNt2Mapper.selectCount(query);
    }

}
