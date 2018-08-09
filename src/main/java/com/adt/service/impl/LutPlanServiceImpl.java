package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LutPlanService;
import com.adt.model.LutPlan;
import com.adt.dao.LutPlanMapper;

@Service
public class LutPlanServiceImpl implements LutPlanService {
    @Resource
    private LutPlanMapper LutPlanMapper;

    @Override
    public List<LutPlan> find(LutPlan lutPlan) {
        return this.LutPlanMapper.list(lutPlan);
    }

    @Override
    public LutPlan view(LutPlan lutPlan) {
        return this.LutPlanMapper.select(lutPlan);
    }
    
    @Override
    public List<LutPlan> findAll() {
        return this.LutPlanMapper.findAll();
    }

    @Override
    public LutPlan findById(String id) {
        return this.LutPlanMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LutPlan lutPlan) {
        this.LutPlanMapper.insert(lutPlan);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LutPlan lutPlan) {
        this.LutPlanMapper.update(lutPlan);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LutPlan lutPlan) {
        this.LutPlanMapper.delete(lutPlan);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LutPlan> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LutPlan>) this.LutPlanMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LutPlanMapper.selectCount(query);
    }

}
