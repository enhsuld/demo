package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LutFormsService;
import com.adt.model.LutForms;
import com.adt.dao.LutFormsMapper;

@Service
public class LutFormsServiceImpl implements LutFormsService {
    @Resource
    private LutFormsMapper LutFormsMapper;

    @Override
    public List<LutForms> find(LutForms lutForms) {
        return this.LutFormsMapper.list(lutForms);
    }

    @Override
    public LutForms view(LutForms lutForms) {
        return this.LutFormsMapper.select(lutForms);
    }
    
    @Override
    public List<LutForms> findAll() {
        return this.LutFormsMapper.findAll();
    }

    @Override
    public LutForms findById(String id) {
        return this.LutFormsMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LutForms lutForms) {
        this.LutFormsMapper.insert(lutForms);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LutForms lutForms) {
        this.LutFormsMapper.update(lutForms);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LutForms lutForms) {
        this.LutFormsMapper.delete(lutForms);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LutForms> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LutForms>) this.LutFormsMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LutFormsMapper.selectCount(query);
    }

}
