package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinCt2aService;
import com.adt.model.FinCt2a;
import com.adt.dao.FinCt2aMapper;

@Service
public class FinCt2aServiceImpl implements FinCt2aService {
    @Resource
    private FinCt2aMapper FinCt2aMapper;

    @Override
    public List<FinCt2a> find(FinCt2a finCt2a) {
        return this.FinCt2aMapper.list(finCt2a);
    }

    @Override
    public FinCt2a view(FinCt2a finCt2a) {
        return this.FinCt2aMapper.select(finCt2a);
    }
    
    @Override
    public List<FinCt2a> findAll() {
        return this.FinCt2aMapper.findAll();
    }

    @Override
    public FinCt2a findById(String id) {
        return this.FinCt2aMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinCt2a finCt2a) {
        this.FinCt2aMapper.insert(finCt2a);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinCt2a finCt2a) {
        this.FinCt2aMapper.update(finCt2a);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinCt2a finCt2a) {
        this.FinCt2aMapper.delete(finCt2a);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinCt2a> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinCt2a>) this.FinCt2aMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinCt2aMapper.selectCount(query);
    }

}
