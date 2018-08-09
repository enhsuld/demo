package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinTrialBalance;

@Mapper
public interface FinTrialBalanceMapper {
    public List<FinTrialBalance> list(FinTrialBalance finTrialBalance);
    public FinTrialBalance select(FinTrialBalance finTrialBalance);
    public void insert(FinTrialBalance finTrialBalance);
    public void update(FinTrialBalance finTrialBalance);
    public void delete(FinTrialBalance finTrialBalance);
    public List<FinTrialBalance> findAll();
    public FinTrialBalance findById(String id);
    
    public List<FinTrialBalance> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
