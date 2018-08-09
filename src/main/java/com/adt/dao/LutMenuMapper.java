package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LutMenu;

@Mapper
public interface LutMenuMapper {
    public List<LutMenu> list(LutMenu lutMenu);
    public LutMenu select(LutMenu lutMenu);
    public void insert(LutMenu lutMenu);
    public void update(LutMenu lutMenu);
    public void delete(LutMenu lutMenu);
    public List<LutMenu> findAll();
    public LutMenu findById(String id);
    
    public List<LutMenu> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
