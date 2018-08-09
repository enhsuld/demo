package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LutPositionService;
import com.adt.model.LutPosition;
import com.adt.dao.LutPositionMapper;

@Service
public class LutPositionServiceImpl implements LutPositionService {
    @Resource
    private LutPositionMapper LutPositionMapper;

    @Override
    public List<LutPosition> find(LutPosition lutPosition) {
        return this.LutPositionMapper.list(lutPosition);
    }

    @Override
    public LutPosition view(LutPosition lutPosition) {
        return this.LutPositionMapper.select(lutPosition);
    }
    
    @Override
    public List<LutPosition> findAll() {
        return this.LutPositionMapper.findAll();
    }

    @Override
    public LutPosition findById(String id) {
        return this.LutPositionMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LutPosition lutPosition) {
        this.LutPositionMapper.insert(lutPosition);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LutPosition lutPosition) {
        this.LutPositionMapper.update(lutPosition);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LutPosition lutPosition) {
        this.LutPositionMapper.delete(lutPosition);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LutPosition> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LutPosition>) this.LutPositionMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LutPositionMapper.selectCount(query);
    }

}
