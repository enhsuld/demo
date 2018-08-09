package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LutReasonService;
import com.adt.model.LutReason;
import com.adt.dao.LutReasonMapper;

@Service
public class LutReasonServiceImpl implements LutReasonService {
    @Resource
    private LutReasonMapper LutReasonMapper;

    @Override
    public List<LutReason> find(LutReason lutReason) {
        return this.LutReasonMapper.list(lutReason);
    }

    @Override
    public LutReason view(LutReason lutReason) {
        return this.LutReasonMapper.select(lutReason);
    }
    
    @Override
    public List<LutReason> findAll() {
        return this.LutReasonMapper.findAll();
    }

    @Override
    public LutReason findById(String id) {
        return this.LutReasonMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LutReason lutReason) {
        this.LutReasonMapper.insert(lutReason);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LutReason lutReason) {
        this.LutReasonMapper.update(lutReason);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LutReason lutReason) {
        this.LutReasonMapper.delete(lutReason);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LutReason> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LutReason>) this.LutReasonMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LutReasonMapper.selectCount(query);
    }

}
