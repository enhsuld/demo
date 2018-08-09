package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LutDepartmentsService;
import com.adt.model.LutDepartments;
import com.adt.dao.LutDepartmentsMapper;

@Service
public class LutDepartmentsServiceImpl implements LutDepartmentsService {
    @Resource
    private LutDepartmentsMapper LutDepartmentsMapper;

    @Override
    public List<LutDepartments> find(LutDepartments lutDepartments) {
        return this.LutDepartmentsMapper.list(lutDepartments);
    }

    @Override
    public LutDepartments view(LutDepartments lutDepartments) {
        return this.LutDepartmentsMapper.select(lutDepartments);
    }
    
    @Override
    public List<LutDepartments> findAll() {
        return this.LutDepartmentsMapper.findAll();
    }

    @Override
    public LutDepartments findById(String id) {
        return this.LutDepartmentsMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LutDepartments lutDepartments) {
        this.LutDepartmentsMapper.insert(lutDepartments);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LutDepartments lutDepartments) {
        this.LutDepartmentsMapper.update(lutDepartments);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LutDepartments lutDepartments) {
        this.LutDepartmentsMapper.delete(lutDepartments);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LutDepartments> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LutDepartments>) this.LutDepartmentsMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LutDepartmentsMapper.selectCount(query);
    }

}
