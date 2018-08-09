package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinAbws;


public interface FinAbwsService {
    public List<FinAbws> find(FinAbws finAbws);
    public FinAbws view(FinAbws finAbws);
    public void add(FinAbws finAbws);
    public void edit(FinAbws finAbws);
    public void remove(FinAbws finAbws);
    public List<FinAbws> findAll();
    public FinAbws findById(String id);
    
    public List<FinAbws> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
