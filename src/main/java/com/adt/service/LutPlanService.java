package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LutPlan;


public interface LutPlanService {
    public List<LutPlan> find(LutPlan lutPlan);
    public LutPlan view(LutPlan lutPlan);
    public void add(LutPlan lutPlan);
    public void edit(LutPlan lutPlan);
    public void remove(LutPlan lutPlan);
    public List<LutPlan> findAll();
    public LutPlan findById(String id);
    
    public List<LutPlan> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
