package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinCtt9;

@Mapper
public interface FinCtt9Mapper {
    public List<FinCtt9> list(FinCtt9 finCtt9);
    public FinCtt9 select(FinCtt9 finCtt9);
    public void insert(FinCtt9 finCtt9);
    public void update(FinCtt9 finCtt9);
    public void delete(FinCtt9 finCtt9);
    public List<FinCtt9> findAll();
    public FinCtt9 findById(String id);
    
    public List<FinCtt9> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
