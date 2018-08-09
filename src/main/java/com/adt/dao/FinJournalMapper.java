package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinJournal;

@Mapper
public interface FinJournalMapper {
    public List<FinJournal> list(FinJournal finJournal);
    public FinJournal select(FinJournal finJournal);
    public void insert(FinJournal finJournal);
    public void update(FinJournal finJournal);
    public void delete(FinJournal finJournal);
    public List<FinJournal> findAll();
    public FinJournal findById(String id);
    
    public List<FinJournal> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
