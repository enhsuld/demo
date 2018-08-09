package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinJournal;


public interface FinJournalService {
    public List<FinJournal> find(FinJournal finJournal);
    public FinJournal view(FinJournal finJournal);
    public void add(FinJournal finJournal);
    public void edit(FinJournal finJournal);
    public void remove(FinJournal finJournal);
    public List<FinJournal> findAll();
    public FinJournal findById(String id);
    
    public List<FinJournal> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
