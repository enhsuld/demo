package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinCtt8;

@Mapper
public interface FinCtt8Mapper {
    public List<FinCtt8> list(FinCtt8 finCtt8);
    public FinCtt8 select(FinCtt8 finCtt8);
    public void insert(FinCtt8 finCtt8);
    public void update(FinCtt8 finCtt8);
    public void delete(FinCtt8 finCtt8);
    public List<FinCtt8> findAll();
    public FinCtt8 findById(String id);
    
    public List<FinCtt8> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
