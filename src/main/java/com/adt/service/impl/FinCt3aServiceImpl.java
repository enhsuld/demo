package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinCt3aService;
import com.adt.model.FinCt3a;
import com.adt.dao.FinCt3aMapper;

@Service
public class FinCt3aServiceImpl implements FinCt3aService {
    @Resource
    private FinCt3aMapper FinCt3aMapper;

    @Override
    public List<FinCt3a> find(FinCt3a finCt3a) {
        return this.FinCt3aMapper.list(finCt3a);
    }

    @Override
    public FinCt3a view(FinCt3a finCt3a) {
        return this.FinCt3aMapper.select(finCt3a);
    }
    
    @Override
    public List<FinCt3a> findAll() {
        return this.FinCt3aMapper.findAll();
    }

    @Override
    public FinCt3a findById(String id) {
        return this.FinCt3aMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinCt3a finCt3a) {
        this.FinCt3aMapper.insert(finCt3a);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinCt3a finCt3a) {
        this.FinCt3aMapper.update(finCt3a);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinCt3a finCt3a) {
        this.FinCt3aMapper.delete(finCt3a);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinCt3a> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinCt3a>) this.FinCt3aMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinCt3aMapper.selectCount(query);
    }

}
