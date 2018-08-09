package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LnkDepartmentPlan;

@Mapper
public interface LnkDepartmentPlanMapper {
    public List<LnkDepartmentPlan> list(LnkDepartmentPlan lnkDepartmentPlan);
    public LnkDepartmentPlan select(LnkDepartmentPlan lnkDepartmentPlan);
    public void insert(LnkDepartmentPlan lnkDepartmentPlan);
    public void update(LnkDepartmentPlan lnkDepartmentPlan);
    public void delete(LnkDepartmentPlan lnkDepartmentPlan);
    public List<LnkDepartmentPlan> findAll();
    public LnkDepartmentPlan findById(String id);
    
    public List<LnkDepartmentPlan> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
