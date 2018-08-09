package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinCtt5;


public interface FinCtt5Service {
    public List<FinCtt5> find(FinCtt5 finCtt5);
    public FinCtt5 view(FinCtt5 finCtt5);
    public void add(FinCtt5 finCtt5);
    public void edit(FinCtt5 finCtt5);
    public void remove(FinCtt5 finCtt5);
    public List<FinCtt5> findAll();
    public FinCtt5 findById(String id);
    
    public List<FinCtt5> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
