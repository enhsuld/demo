package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LutCategory;


public interface LutCategoryService {
    public List<LutCategory> find(LutCategory lutCategory);
    public LutCategory view(LutCategory lutCategory);
    public void add(LutCategory lutCategory);
    public void edit(LutCategory lutCategory);
    public void remove(LutCategory lutCategory);
    public List<LutCategory> findAll();
    public LutCategory findById(String id);
    
    public List<LutCategory> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
