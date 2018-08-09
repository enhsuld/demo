package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinNt2;


public interface FinNt2Service {
    public List<FinNt2> find(FinNt2 finNt2);
    public FinNt2 view(FinNt2 finNt2);
    public void add(FinNt2 finNt2);
    public void edit(FinNt2 finNt2);
    public void remove(FinNt2 finNt2);
    public List<FinNt2> findAll();
    public FinNt2 findById(String id);
    
    public List<FinNt2> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
