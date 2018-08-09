package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinCt1aService;
import com.adt.model.FinCt1a;
import com.adt.dao.FinCt1aMapper;

@Service
public class FinCt1aServiceImpl implements FinCt1aService {
    @Resource
    private FinCt1aMapper FinCt1aMapper;

    @Override
    public List<FinCt1a> find(FinCt1a finCt1a) {
        return this.FinCt1aMapper.list(finCt1a);
    }

    @Override
    public FinCt1a view(FinCt1a finCt1a) {
        return this.FinCt1aMapper.select(finCt1a);
    }
    
    @Override
    public List<FinCt1a> findAll() {
        return this.FinCt1aMapper.findAll();
    }

    @Override
    public FinCt1a findById(String id) {
        return this.FinCt1aMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinCt1a finCt1a) {
        this.FinCt1aMapper.insert(finCt1a);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinCt1a finCt1a) {
        this.FinCt1aMapper.update(finCt1a);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinCt1a finCt1a) {
        this.FinCt1aMapper.delete(finCt1a);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinCt1a> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinCt1a>) this.FinCt1aMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinCt1aMapper.selectCount(query);
    }

}
