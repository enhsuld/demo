package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinCtt2Service;
import com.adt.model.FinCtt2;
import com.adt.dao.FinCtt2Mapper;

@Service
public class FinCtt2ServiceImpl implements FinCtt2Service {
    @Resource
    private FinCtt2Mapper FinCtt2Mapper;

    @Override
    public List<FinCtt2> find(FinCtt2 finCtt2) {
        return this.FinCtt2Mapper.list(finCtt2);
    }

    @Override
    public FinCtt2 view(FinCtt2 finCtt2) {
        return this.FinCtt2Mapper.select(finCtt2);
    }
    
    @Override
    public List<FinCtt2> findAll() {
        return this.FinCtt2Mapper.findAll();
    }

    @Override
    public FinCtt2 findById(String id) {
        return this.FinCtt2Mapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinCtt2 finCtt2) {
        this.FinCtt2Mapper.insert(finCtt2);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinCtt2 finCtt2) {
        this.FinCtt2Mapper.update(finCtt2);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinCtt2 finCtt2) {
        this.FinCtt2Mapper.delete(finCtt2);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinCtt2> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinCtt2>) this.FinCtt2Mapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinCtt2Mapper.selectCount(query);
    }

}
