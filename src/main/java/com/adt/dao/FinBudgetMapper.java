package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinBudget;

@Mapper
public interface FinBudgetMapper {
    public List<FinBudget> list(FinBudget finBudget);
    public FinBudget select(FinBudget finBudget);
    public void insert(FinBudget finBudget);
    public void update(FinBudget finBudget);
    public void delete(FinBudget finBudget);
    public List<FinBudget> findAll();
    public FinBudget findById(String id);
    
    public List<FinBudget> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
