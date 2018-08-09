package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LutRole;

@Mapper
public interface LutRoleMapper {
    public List<LutRole> list(LutRole lutRole);
    public LutRole select(LutRole lutRole);
    public void insert(LutRole lutRole);
    public void update(LutRole lutRole);
    public void delete(LutRole lutRole);
    public List<LutRole> findAll();
    public LutRole findById(String id);
    
    public List<LutRole> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
