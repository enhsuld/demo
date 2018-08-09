package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LnkDepartmentPlan;


public interface LnkDepartmentPlanService {
    public List<LnkDepartmentPlan> find(LnkDepartmentPlan lnkDepartmentPlan);
    public LnkDepartmentPlan view(LnkDepartmentPlan lnkDepartmentPlan);
    public void add(LnkDepartmentPlan lnkDepartmentPlan);
    public void edit(LnkDepartmentPlan lnkDepartmentPlan);
    public void remove(LnkDepartmentPlan lnkDepartmentPlan);
    public List<LnkDepartmentPlan> findAll();
    public LnkDepartmentPlan findById(String id);
    
    public List<LnkDepartmentPlan> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
