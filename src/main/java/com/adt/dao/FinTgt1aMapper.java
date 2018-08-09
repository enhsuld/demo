package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinTgt1a;

@Mapper
public interface FinTgt1aMapper {
    public List<FinTgt1a> list(FinTgt1a finTgt1a);
    public FinTgt1a select(FinTgt1a finTgt1a);
    public void insert(FinTgt1a finTgt1a);
    public void update(FinTgt1a finTgt1a);
    public void delete(FinTgt1a finTgt1a);
    public List<FinTgt1a> findAll();
    public FinTgt1a findById(String id);
    
    public List<FinTgt1a> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
