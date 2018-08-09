package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LutExpProgcategoryService;
import com.adt.model.LutExpProgcategory;
import com.adt.dao.LutExpProgcategoryMapper;

@Service
public class LutExpProgcategoryServiceImpl implements LutExpProgcategoryService {
    @Resource
    private LutExpProgcategoryMapper LutExpProgcategoryMapper;

    @Override
    public List<LutExpProgcategory> find(LutExpProgcategory lutExpProgcategory) {
        return this.LutExpProgcategoryMapper.list(lutExpProgcategory);
    }

    @Override
    public LutExpProgcategory view(LutExpProgcategory lutExpProgcategory) {
        return this.LutExpProgcategoryMapper.select(lutExpProgcategory);
    }
    
    @Override
    public List<LutExpProgcategory> findAll() {
        return this.LutExpProgcategoryMapper.findAll();
    }

    @Override
    public LutExpProgcategory findById(String id) {
        return this.LutExpProgcategoryMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LutExpProgcategory lutExpProgcategory) {
        this.LutExpProgcategoryMapper.insert(lutExpProgcategory);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LutExpProgcategory lutExpProgcategory) {
        this.LutExpProgcategoryMapper.update(lutExpProgcategory);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LutExpProgcategory lutExpProgcategory) {
        this.LutExpProgcategoryMapper.delete(lutExpProgcategory);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LutExpProgcategory> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LutExpProgcategory>) this.LutExpProgcategoryMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LutExpProgcategoryMapper.selectCount(query);
    }

}
