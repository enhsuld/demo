package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinCtt9;


public interface FinCtt9Service {
    public List<FinCtt9> find(FinCtt9 finCtt9);
    public FinCtt9 view(FinCtt9 finCtt9);
    public void add(FinCtt9 finCtt9);
    public void edit(FinCtt9 finCtt9);
    public void remove(FinCtt9 finCtt9);
    public List<FinCtt9> findAll();
    public FinCtt9 findById(String id);
    
    public List<FinCtt9> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
