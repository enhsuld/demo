package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinCtt7;


public interface FinCtt7Service {
    public List<FinCtt7> find(FinCtt7 finCtt7);
    public FinCtt7 view(FinCtt7 finCtt7);
    public void add(FinCtt7 finCtt7);
    public void edit(FinCtt7 finCtt7);
    public void remove(FinCtt7 finCtt7);
    public List<FinCtt7> findAll();
    public FinCtt7 findById(String id);
    
    public List<FinCtt7> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
