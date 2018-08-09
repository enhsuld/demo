package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinCt3a;


public interface FinCt3aService {
    public List<FinCt3a> find(FinCt3a finCt3a);
    public FinCt3a view(FinCt3a finCt3a);
    public void add(FinCt3a finCt3a);
    public void edit(FinCt3a finCt3a);
    public void remove(FinCt3a finCt3a);
    public List<FinCt3a> findAll();
    public FinCt3a findById(String id);
    
    public List<FinCt3a> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
