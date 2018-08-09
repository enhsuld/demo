package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LutCategoryService;
import com.adt.model.LutCategory;
import com.adt.dao.LutCategoryMapper;

@Service
public class LutCategoryServiceImpl implements LutCategoryService {
    @Resource
    private LutCategoryMapper LutCategoryMapper;

    @Override
    public List<LutCategory> find(LutCategory lutCategory) {
        return this.LutCategoryMapper.list(lutCategory);
    }

    @Override
    public LutCategory view(LutCategory lutCategory) {
        return this.LutCategoryMapper.select(lutCategory);
    }
    
    @Override
    public List<LutCategory> findAll() {
        return this.LutCategoryMapper.findAll();
    }

    @Override
    public LutCategory findById(String id) {
        return this.LutCategoryMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LutCategory lutCategory) {
        this.LutCategoryMapper.insert(lutCategory);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LutCategory lutCategory) {
        this.LutCategoryMapper.update(lutCategory);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LutCategory lutCategory) {
        this.LutCategoryMapper.delete(lutCategory);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LutCategory> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LutCategory>) this.LutCategoryMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LutCategoryMapper.selectCount(query);
    }

}
