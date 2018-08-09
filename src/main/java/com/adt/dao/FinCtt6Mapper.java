package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinCtt6;

@Mapper
public interface FinCtt6Mapper {
    public List<FinCtt6> list(FinCtt6 finCtt6);
    public FinCtt6 select(FinCtt6 finCtt6);
    public void insert(FinCtt6 finCtt6);
    public void update(FinCtt6 finCtt6);
    public void delete(FinCtt6 finCtt6);
    public List<FinCtt6> findAll();
    public FinCtt6 findById(String id);
    
    public List<FinCtt6> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
