package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LutStaus;


public interface LutStausService {
    public List<LutStaus> find(LutStaus lutStaus);
    public LutStaus view(LutStaus lutStaus);
    public void add(LutStaus lutStaus);
    public void edit(LutStaus lutStaus);
    public void remove(LutStaus lutStaus);
    public List<LutStaus> findAll();
    public LutStaus findById(String id);
    
    public List<LutStaus> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
