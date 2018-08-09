package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LnkDepartmentPlanService;
import com.adt.model.LnkDepartmentPlan;
import com.adt.dao.LnkDepartmentPlanMapper;

@Service
public class LnkDepartmentPlanServiceImpl implements LnkDepartmentPlanService {
    @Resource
    private LnkDepartmentPlanMapper LnkDepartmentPlanMapper;

    @Override
    public List<LnkDepartmentPlan> find(LnkDepartmentPlan lnkDepartmentPlan) {
        return this.LnkDepartmentPlanMapper.list(lnkDepartmentPlan);
    }

    @Override
    public LnkDepartmentPlan view(LnkDepartmentPlan lnkDepartmentPlan) {
        return this.LnkDepartmentPlanMapper.select(lnkDepartmentPlan);
    }
    
    @Override
    public List<LnkDepartmentPlan> findAll() {
        return this.LnkDepartmentPlanMapper.findAll();
    }

    @Override
    public LnkDepartmentPlan findById(String id) {
        return this.LnkDepartmentPlanMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LnkDepartmentPlan lnkDepartmentPlan) {
        this.LnkDepartmentPlanMapper.insert(lnkDepartmentPlan);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LnkDepartmentPlan lnkDepartmentPlan) {
        this.LnkDepartmentPlanMapper.update(lnkDepartmentPlan);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LnkDepartmentPlan lnkDepartmentPlan) {
        this.LnkDepartmentPlanMapper.delete(lnkDepartmentPlan);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LnkDepartmentPlan> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LnkDepartmentPlan>) this.LnkDepartmentPlanMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LnkDepartmentPlanMapper.selectCount(query);
    }

}
