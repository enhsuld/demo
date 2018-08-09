package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinCtt2;


public interface FinCtt2Service {
    public List<FinCtt2> find(FinCtt2 finCtt2);
    public FinCtt2 view(FinCtt2 finCtt2);
    public void add(FinCtt2 finCtt2);
    public void edit(FinCtt2 finCtt2);
    public void remove(FinCtt2 finCtt2);
    public List<FinCtt2> findAll();
    public FinCtt2 findById(String id);
    
    public List<FinCtt2> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
