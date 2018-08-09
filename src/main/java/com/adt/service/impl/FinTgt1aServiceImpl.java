package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinTgt1aService;
import com.adt.model.FinTgt1a;
import com.adt.dao.FinTgt1aMapper;

@Service
public class FinTgt1aServiceImpl implements FinTgt1aService {
    @Resource
    private FinTgt1aMapper FinTgt1aMapper;

    @Override
    public List<FinTgt1a> find(FinTgt1a finTgt1a) {
        return this.FinTgt1aMapper.list(finTgt1a);
    }

    @Override
    public FinTgt1a view(FinTgt1a finTgt1a) {
        return this.FinTgt1aMapper.select(finTgt1a);
    }
    
    @Override
    public List<FinTgt1a> findAll() {
        return this.FinTgt1aMapper.findAll();
    }

    @Override
    public FinTgt1a findById(String id) {
        return this.FinTgt1aMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinTgt1a finTgt1a) {
        this.FinTgt1aMapper.insert(finTgt1a);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinTgt1a finTgt1a) {
        this.FinTgt1aMapper.update(finTgt1a);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinTgt1a finTgt1a) {
        this.FinTgt1aMapper.delete(finTgt1a);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinTgt1a> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinTgt1a>) this.FinTgt1aMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinTgt1aMapper.selectCount(query);
    }

}
