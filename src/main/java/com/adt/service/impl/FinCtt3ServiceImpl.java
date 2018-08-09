package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinCtt3Service;
import com.adt.model.FinCtt3;
import com.adt.dao.FinCtt3Mapper;

@Service
public class FinCtt3ServiceImpl implements FinCtt3Service {
    @Resource
    private FinCtt3Mapper FinCtt3Mapper;

    @Override
    public List<FinCtt3> find(FinCtt3 finCtt3) {
        return this.FinCtt3Mapper.list(finCtt3);
    }

    @Override
    public FinCtt3 view(FinCtt3 finCtt3) {
        return this.FinCtt3Mapper.select(finCtt3);
    }
    
    @Override
    public List<FinCtt3> findAll() {
        return this.FinCtt3Mapper.findAll();
    }

    @Override
    public FinCtt3 findById(String id) {
        return this.FinCtt3Mapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinCtt3 finCtt3) {
        this.FinCtt3Mapper.insert(finCtt3);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinCtt3 finCtt3) {
        this.FinCtt3Mapper.update(finCtt3);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinCtt3 finCtt3) {
        this.FinCtt3Mapper.delete(finCtt3);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinCtt3> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinCtt3>) this.FinCtt3Mapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinCtt3Mapper.selectCount(query);
    }

}
