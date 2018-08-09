package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinCtt3;


public interface FinCtt3Service {
    public List<FinCtt3> find(FinCtt3 finCtt3);
    public FinCtt3 view(FinCtt3 finCtt3);
    public void add(FinCtt3 finCtt3);
    public void edit(FinCtt3 finCtt3);
    public void remove(FinCtt3 finCtt3);
    public List<FinCtt3> findAll();
    public FinCtt3 findById(String id);
    
    public List<FinCtt3> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
