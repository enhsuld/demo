package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinCtt8;


public interface FinCtt8Service {
    public List<FinCtt8> find(FinCtt8 finCtt8);
    public FinCtt8 view(FinCtt8 finCtt8);
    public void add(FinCtt8 finCtt8);
    public void edit(FinCtt8 finCtt8);
    public void remove(FinCtt8 finCtt8);
    public List<FinCtt8> findAll();
    public FinCtt8 findById(String id);
    
    public List<FinCtt8> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
