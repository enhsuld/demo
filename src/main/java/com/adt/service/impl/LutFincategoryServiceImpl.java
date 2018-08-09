package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LutFincategoryService;
import com.adt.model.LutFincategory;
import com.adt.dao.LutFincategoryMapper;

@Service
public class LutFincategoryServiceImpl implements LutFincategoryService {
    @Resource
    private LutFincategoryMapper LutFincategoryMapper;

    @Override
    public List<LutFincategory> find(LutFincategory lutFincategory) {
        return this.LutFincategoryMapper.list(lutFincategory);
    }

    @Override
    public LutFincategory view(LutFincategory lutFincategory) {
        return this.LutFincategoryMapper.select(lutFincategory);
    }
    
    @Override
    public List<LutFincategory> findAll() {
        return this.LutFincategoryMapper.findAll();
    }

    @Override
    public LutFincategory findById(String id) {
        return this.LutFincategoryMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LutFincategory lutFincategory) {
        this.LutFincategoryMapper.insert(lutFincategory);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LutFincategory lutFincategory) {
        this.LutFincategoryMapper.update(lutFincategory);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LutFincategory lutFincategory) {
        this.LutFincategoryMapper.delete(lutFincategory);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LutFincategory> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LutFincategory>) this.LutFincategoryMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LutFincategoryMapper.selectCount(query);
    }

}
