package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinCtt6Service;
import com.adt.model.FinCtt6;
import com.adt.dao.FinCtt6Mapper;

@Service
public class FinCtt6ServiceImpl implements FinCtt6Service {
    @Resource
    private FinCtt6Mapper FinCtt6Mapper;

    @Override
    public List<FinCtt6> find(FinCtt6 finCtt6) {
        return this.FinCtt6Mapper.list(finCtt6);
    }

    @Override
    public FinCtt6 view(FinCtt6 finCtt6) {
        return this.FinCtt6Mapper.select(finCtt6);
    }
    
    @Override
    public List<FinCtt6> findAll() {
        return this.FinCtt6Mapper.findAll();
    }

    @Override
    public FinCtt6 findById(String id) {
        return this.FinCtt6Mapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinCtt6 finCtt6) {
        this.FinCtt6Mapper.insert(finCtt6);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinCtt6 finCtt6) {
        this.FinCtt6Mapper.update(finCtt6);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinCtt6 finCtt6) {
        this.FinCtt6Mapper.delete(finCtt6);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinCtt6> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinCtt6>) this.FinCtt6Mapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinCtt6Mapper.selectCount(query);
    }

}
