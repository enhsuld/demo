package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LnkMainUsers;


public interface LnkMainUsersService {
    public List<LnkMainUsers> find(LnkMainUsers lnkMainUsers);
    public LnkMainUsers view(LnkMainUsers lnkMainUsers);
    public void add(LnkMainUsers lnkMainUsers);
    public void edit(LnkMainUsers lnkMainUsers);
    public void remove(LnkMainUsers lnkMainUsers);
    public List<LnkMainUsers> findAll();
    public LnkMainUsers findById(String id);
    
    public List<LnkMainUsers> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
