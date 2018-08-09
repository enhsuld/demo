package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LutPlan;

@Mapper
public interface LutPlanMapper {
    public List<LutPlan> list(LutPlan lutPlan);
    public LutPlan select(LutPlan lutPlan);
    public void insert(LutPlan lutPlan);
    public void update(LutPlan lutPlan);
    public void delete(LutPlan lutPlan);
    public List<LutPlan> findAll();
    public LutPlan findById(String id);
    
    public List<LutPlan> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
