package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LutDepartments;


public interface LutDepartmentsService {
    public List<LutDepartments> find(LutDepartments lutDepartments);
    public LutDepartments view(LutDepartments lutDepartments);
    public void add(LutDepartments lutDepartments);
    public void edit(LutDepartments lutDepartments);
    public void remove(LutDepartments lutDepartments);
    public List<LutDepartments> findAll();
    public LutDepartments findById(String id);
    
    public List<LutDepartments> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
