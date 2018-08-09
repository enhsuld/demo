package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinCtt5Service;
import com.adt.model.FinCtt5;
import com.adt.dao.FinCtt5Mapper;

@Service
public class FinCtt5ServiceImpl implements FinCtt5Service {
    @Resource
    private FinCtt5Mapper FinCtt5Mapper;

    @Override
    public List<FinCtt5> find(FinCtt5 finCtt5) {
        return this.FinCtt5Mapper.list(finCtt5);
    }

    @Override
    public FinCtt5 view(FinCtt5 finCtt5) {
        return this.FinCtt5Mapper.select(finCtt5);
    }
    
    @Override
    public List<FinCtt5> findAll() {
        return this.FinCtt5Mapper.findAll();
    }

    @Override
    public FinCtt5 findById(String id) {
        return this.FinCtt5Mapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinCtt5 finCtt5) {
        this.FinCtt5Mapper.insert(finCtt5);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinCtt5 finCtt5) {
        this.FinCtt5Mapper.update(finCtt5);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinCtt5 finCtt5) {
        this.FinCtt5Mapper.delete(finCtt5);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinCtt5> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinCtt5>) this.FinCtt5Mapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinCtt5Mapper.selectCount(query);
    }

}
