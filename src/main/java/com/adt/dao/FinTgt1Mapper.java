package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinTgt1;

@Mapper
public interface FinTgt1Mapper {
    public List<FinTgt1> list(FinTgt1 finTgt1);
    public FinTgt1 select(FinTgt1 finTgt1);
    public void insert(FinTgt1 finTgt1);
    public void update(FinTgt1 finTgt1);
    public void delete(FinTgt1 finTgt1);
    public List<FinTgt1> findAll();
    public FinTgt1 findById(String id);
    
    public List<FinTgt1> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
