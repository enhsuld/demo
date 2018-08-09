package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinCt4a;


public interface FinCt4aService {
    public List<FinCt4a> find(FinCt4a finCt4a);
    public FinCt4a view(FinCt4a finCt4a);
    public void add(FinCt4a finCt4a);
    public void edit(FinCt4a finCt4a);
    public void remove(FinCt4a finCt4a);
    public List<FinCt4a> findAll();
    public FinCt4a findById(String id);
    
    public List<FinCt4a> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
