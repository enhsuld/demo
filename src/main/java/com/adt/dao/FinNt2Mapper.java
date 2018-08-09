package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinNt2;

@Mapper
public interface FinNt2Mapper {
    public List<FinNt2> list(FinNt2 finNt2);
    public FinNt2 select(FinNt2 finNt2);
    public void insert(FinNt2 finNt2);
    public void update(FinNt2 finNt2);
    public void delete(FinNt2 finNt2);
    public List<FinNt2> findAll();
    public FinNt2 findById(String id);
    
    public List<FinNt2> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
