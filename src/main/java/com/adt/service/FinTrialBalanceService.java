package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinTrialBalance;


public interface FinTrialBalanceService {
    public List<FinTrialBalance> find(FinTrialBalance finTrialBalance);
    public FinTrialBalance view(FinTrialBalance finTrialBalance);
    public void add(FinTrialBalance finTrialBalance);
    public void edit(FinTrialBalance finTrialBalance);
    public void remove(FinTrialBalance finTrialBalance);
    public List<FinTrialBalance> findAll();
    public FinTrialBalance findById(String id);
    
    public List<FinTrialBalance> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
