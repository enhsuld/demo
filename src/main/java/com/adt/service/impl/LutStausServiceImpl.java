package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LutStausService;
import com.adt.model.LutStaus;
import com.adt.dao.LutStausMapper;

@Service
public class LutStausServiceImpl implements LutStausService {
    @Resource
    private LutStausMapper LutStausMapper;

    @Override
    public List<LutStaus> find(LutStaus lutStaus) {
        return this.LutStausMapper.list(lutStaus);
    }

    @Override
    public LutStaus view(LutStaus lutStaus) {
        return this.LutStausMapper.select(lutStaus);
    }
    
    @Override
    public List<LutStaus> findAll() {
        return this.LutStausMapper.findAll();
    }

    @Override
    public LutStaus findById(String id) {
        return this.LutStausMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LutStaus lutStaus) {
        this.LutStausMapper.insert(lutStaus);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LutStaus lutStaus) {
        this.LutStausMapper.update(lutStaus);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LutStaus lutStaus) {
        this.LutStausMapper.delete(lutStaus);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LutStaus> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LutStaus>) this.LutStausMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LutStausMapper.selectCount(query);
    }

}
