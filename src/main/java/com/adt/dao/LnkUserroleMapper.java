package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LnkUserrole;

@Mapper
public interface LnkUserroleMapper {
    public List<LnkUserrole> list(LnkUserrole lnkUserrole);
    public LnkUserrole select(LnkUserrole lnkUserrole);
    public void insert(LnkUserrole lnkUserrole);
    public void update(LnkUserrole lnkUserrole);
    public void delete(LnkUserrole lnkUserrole);
    public List<LnkUserrole> findAll();
    public LnkUserrole findById(String id);
    
    public List<LnkUserrole> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
