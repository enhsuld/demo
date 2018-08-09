package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinCtt4Service;
import com.adt.model.FinCtt4;
import com.adt.dao.FinCtt4Mapper;

@Service
public class FinCtt4ServiceImpl implements FinCtt4Service {
    @Resource
    private FinCtt4Mapper FinCtt4Mapper;

    @Override
    public List<FinCtt4> find(FinCtt4 finCtt4) {
        return this.FinCtt4Mapper.list(finCtt4);
    }

    @Override
    public FinCtt4 view(FinCtt4 finCtt4) {
        return this.FinCtt4Mapper.select(finCtt4);
    }
    
    @Override
    public List<FinCtt4> findAll() {
        return this.FinCtt4Mapper.findAll();
    }

    @Override
    public FinCtt4 findById(String id) {
        return this.FinCtt4Mapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinCtt4 finCtt4) {
        this.FinCtt4Mapper.insert(finCtt4);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinCtt4 finCtt4) {
        this.FinCtt4Mapper.update(finCtt4);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinCtt4 finCtt4) {
        this.FinCtt4Mapper.delete(finCtt4);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinCtt4> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinCtt4>) this.FinCtt4Mapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinCtt4Mapper.selectCount(query);
    }

}
