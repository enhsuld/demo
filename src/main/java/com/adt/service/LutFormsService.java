package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LutForms;


public interface LutFormsService {
    public List<LutForms> find(LutForms lutForms);
    public LutForms view(LutForms lutForms);
    public void add(LutForms lutForms);
    public void edit(LutForms lutForms);
    public void remove(LutForms lutForms);
    public List<LutForms> findAll();
    public LutForms findById(String id);
    
    public List<LutForms> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
