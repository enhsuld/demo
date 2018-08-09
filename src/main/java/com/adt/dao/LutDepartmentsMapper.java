package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LutDepartments;

@Mapper
public interface LutDepartmentsMapper {
    public List<LutDepartments> list(LutDepartments lutDepartments);
    public LutDepartments select(LutDepartments lutDepartments);
    public void insert(LutDepartments lutDepartments);
    public void update(LutDepartments lutDepartments);
    public void delete(LutDepartments lutDepartments);
    public List<LutDepartments> findAll();
    public LutDepartments findById(String id);
    
    public List<LutDepartments> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
