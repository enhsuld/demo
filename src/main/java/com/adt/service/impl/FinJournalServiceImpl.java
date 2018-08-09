package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinJournalService;
import com.adt.model.FinJournal;
import com.adt.dao.FinJournalMapper;

@Service
public class FinJournalServiceImpl implements FinJournalService {
    @Resource
    private FinJournalMapper FinJournalMapper;

    @Override
    public List<FinJournal> find(FinJournal finJournal) {
        return this.FinJournalMapper.list(finJournal);
    }

    @Override
    public FinJournal view(FinJournal finJournal) {
        return this.FinJournalMapper.select(finJournal);
    }
    
    @Override
    public List<FinJournal> findAll() {
        return this.FinJournalMapper.findAll();
    }

    @Override
    public FinJournal findById(String id) {
        return this.FinJournalMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinJournal finJournal) {
        this.FinJournalMapper.insert(finJournal);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinJournal finJournal) {
        this.FinJournalMapper.update(finJournal);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinJournal finJournal) {
        this.FinJournalMapper.delete(finJournal);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinJournal> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinJournal>) this.FinJournalMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinJournalMapper.selectCount(query);
    }

}
