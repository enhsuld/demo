package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LnkMenurole;

@Mapper
public interface LnkMenuroleMapper {
    public List<LnkMenurole> list(LnkMenurole lnkMenurole);
    public LnkMenurole select(LnkMenurole lnkMenurole);
    public void insert(LnkMenurole lnkMenurole);
    public void update(LnkMenurole lnkMenurole);
    public void delete(LnkMenurole lnkMenurole);
    public List<LnkMenurole> findAll();
    public LnkMenurole findById(String id);
    
    public List<LnkMenurole> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
