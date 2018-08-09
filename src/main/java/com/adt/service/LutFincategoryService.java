package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LutFincategory;


public interface LutFincategoryService {
    public List<LutFincategory> find(LutFincategory lutFincategory);
    public LutFincategory view(LutFincategory lutFincategory);
    public void add(LutFincategory lutFincategory);
    public void edit(LutFincategory lutFincategory);
    public void remove(LutFincategory lutFincategory);
    public List<LutFincategory> findAll();
    public LutFincategory findById(String id);
    
    public List<LutFincategory> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
