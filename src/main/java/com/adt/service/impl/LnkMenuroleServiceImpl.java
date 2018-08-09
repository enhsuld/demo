package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LnkMenuroleService;
import com.adt.model.LnkMenurole;
import com.adt.dao.LnkMenuroleMapper;

@Service
public class LnkMenuroleServiceImpl implements LnkMenuroleService {
    @Resource
    private LnkMenuroleMapper LnkMenuroleMapper;

    @Override
    public List<LnkMenurole> find(LnkMenurole lnkMenurole) {
        return this.LnkMenuroleMapper.list(lnkMenurole);
    }

    @Override
    public LnkMenurole view(LnkMenurole lnkMenurole) {
        return this.LnkMenuroleMapper.select(lnkMenurole);
    }
    
    @Override
    public List<LnkMenurole> findAll() {
        return this.LnkMenuroleMapper.findAll();
    }

    @Override
    public LnkMenurole findById(String id) {
        return this.LnkMenuroleMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LnkMenurole lnkMenurole) {
        this.LnkMenuroleMapper.insert(lnkMenurole);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LnkMenurole lnkMenurole) {
        this.LnkMenuroleMapper.update(lnkMenurole);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LnkMenurole lnkMenurole) {
        this.LnkMenuroleMapper.delete(lnkMenurole);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LnkMenurole> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LnkMenurole>) this.LnkMenuroleMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LnkMenuroleMapper.selectCount(query);
    }

}
