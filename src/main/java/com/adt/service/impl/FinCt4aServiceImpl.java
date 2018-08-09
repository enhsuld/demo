package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinCt4aService;
import com.adt.model.FinCt4a;
import com.adt.dao.FinCt4aMapper;

@Service
public class FinCt4aServiceImpl implements FinCt4aService {
    @Resource
    private FinCt4aMapper FinCt4aMapper;

    @Override
    public List<FinCt4a> find(FinCt4a finCt4a) {
        return this.FinCt4aMapper.list(finCt4a);
    }

    @Override
    public FinCt4a view(FinCt4a finCt4a) {
        return this.FinCt4aMapper.select(finCt4a);
    }
    
    @Override
    public List<FinCt4a> findAll() {
        return this.FinCt4aMapper.findAll();
    }

    @Override
    public FinCt4a findById(String id) {
        return this.FinCt4aMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinCt4a finCt4a) {
        this.FinCt4aMapper.insert(finCt4a);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinCt4a finCt4a) {
        this.FinCt4aMapper.update(finCt4a);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinCt4a finCt4a) {
        this.FinCt4aMapper.delete(finCt4a);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinCt4a> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinCt4a>) this.FinCt4aMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinCt4aMapper.selectCount(query);
    }

}
