package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinCtt7;

@Mapper
public interface FinCtt7Mapper {
    public List<FinCtt7> list(FinCtt7 finCtt7);
    public FinCtt7 select(FinCtt7 finCtt7);
    public void insert(FinCtt7 finCtt7);
    public void update(FinCtt7 finCtt7);
    public void delete(FinCtt7 finCtt7);
    public List<FinCtt7> findAll();
    public FinCtt7 findById(String id);
    
    public List<FinCtt7> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
