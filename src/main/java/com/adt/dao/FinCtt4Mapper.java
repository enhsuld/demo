package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinCtt4;

@Mapper
public interface FinCtt4Mapper {
    public List<FinCtt4> list(FinCtt4 finCtt4);
    public FinCtt4 select(FinCtt4 finCtt4);
    public void insert(FinCtt4 finCtt4);
    public void update(FinCtt4 finCtt4);
    public void delete(FinCtt4 finCtt4);
    public List<FinCtt4> findAll();
    public FinCtt4 findById(String id);
    
    public List<FinCtt4> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
