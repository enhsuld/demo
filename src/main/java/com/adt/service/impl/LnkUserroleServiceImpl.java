package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LnkUserroleService;
import com.adt.model.LnkUserrole;
import com.adt.dao.LnkUserroleMapper;

@Service
public class LnkUserroleServiceImpl implements LnkUserroleService {
    @Resource
    private LnkUserroleMapper LnkUserroleMapper;

    @Override
    public List<LnkUserrole> find(LnkUserrole lnkUserrole) {
        return this.LnkUserroleMapper.list(lnkUserrole);
    }

    @Override
    public LnkUserrole view(LnkUserrole lnkUserrole) {
        return this.LnkUserroleMapper.select(lnkUserrole);
    }
    
    @Override
    public List<LnkUserrole> findAll() {
        return this.LnkUserroleMapper.findAll();
    }

    @Override
    public LnkUserrole findById(String id) {
        return this.LnkUserroleMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LnkUserrole lnkUserrole) {
        this.LnkUserroleMapper.insert(lnkUserrole);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LnkUserrole lnkUserrole) {
        this.LnkUserroleMapper.update(lnkUserrole);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LnkUserrole lnkUserrole) {
        this.LnkUserroleMapper.delete(lnkUserrole);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LnkUserrole> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LnkUserrole>) this.LnkUserroleMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LnkUserroleMapper.selectCount(query);
    }

}
