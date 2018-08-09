package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LutStaus;

@Mapper
public interface LutStausMapper {
    public List<LutStaus> list(LutStaus lutStaus);
    public LutStaus select(LutStaus lutStaus);
    public void insert(LutStaus lutStaus);
    public void update(LutStaus lutStaus);
    public void delete(LutStaus lutStaus);
    public List<LutStaus> findAll();
    public LutStaus findById(String id);
    
    public List<LutStaus> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
