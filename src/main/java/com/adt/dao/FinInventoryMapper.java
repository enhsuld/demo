package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinInventory;

@Mapper
public interface FinInventoryMapper {
    public List<FinInventory> list(FinInventory finInventory);
    public FinInventory select(FinInventory finInventory);
    public void insert(FinInventory finInventory);
    public void update(FinInventory finInventory);
    public void delete(FinInventory finInventory);
    public List<FinInventory> findAll();
    public FinInventory findById(String id);
    
    public List<FinInventory> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
