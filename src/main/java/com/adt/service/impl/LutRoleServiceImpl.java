package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LutRoleService;
import com.adt.model.LutRole;
import com.adt.dao.LutRoleMapper;

@Service
public class LutRoleServiceImpl implements LutRoleService {
    @Resource
    private LutRoleMapper LutRoleMapper;

    @Override
    public List<LutRole> find(LutRole lutRole) {
        return this.LutRoleMapper.list(lutRole);
    }

    @Override
    public LutRole view(LutRole lutRole) {
        return this.LutRoleMapper.select(lutRole);
    }
    
    @Override
    public List<LutRole> findAll() {
        return this.LutRoleMapper.findAll();
    }

    @Override
    public LutRole findById(String id) {
        return this.LutRoleMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LutRole lutRole) {
        this.LutRoleMapper.insert(lutRole);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LutRole lutRole) {
        this.LutRoleMapper.update(lutRole);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LutRole lutRole) {
        this.LutRoleMapper.delete(lutRole);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LutRole> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LutRole>) this.LutRoleMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LutRoleMapper.selectCount(query);
    }

}
