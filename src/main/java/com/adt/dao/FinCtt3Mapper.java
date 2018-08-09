package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinCtt3;

@Mapper
public interface FinCtt3Mapper {
    public List<FinCtt3> list(FinCtt3 finCtt3);
    public FinCtt3 select(FinCtt3 finCtt3);
    public void insert(FinCtt3 finCtt3);
    public void update(FinCtt3 finCtt3);
    public void delete(FinCtt3 finCtt3);
    public List<FinCtt3> findAll();
    public FinCtt3 findById(String id);
    
    public List<FinCtt3> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
