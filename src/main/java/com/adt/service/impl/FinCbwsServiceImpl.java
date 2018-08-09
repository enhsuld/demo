package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinCbwsService;
import com.adt.model.FinCbws;
import com.adt.dao.FinCbwsMapper;

@Service
public class FinCbwsServiceImpl implements FinCbwsService {
    @Resource
    private FinCbwsMapper FinCbwsMapper;

    @Override
    public List<FinCbws> find(FinCbws finCbws) {
        return this.FinCbwsMapper.list(finCbws);
    }

    @Override
    public FinCbws view(FinCbws finCbws) {
        return this.FinCbwsMapper.select(finCbws);
    }
    
    @Override
    public List<FinCbws> findAll() {
        return this.FinCbwsMapper.findAll();
    }

    @Override
    public FinCbws findById(String id) {
        return this.FinCbwsMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinCbws finCbws) {
        this.FinCbwsMapper.insert(finCbws);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinCbws finCbws) {
        this.FinCbwsMapper.update(finCbws);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinCbws finCbws) {
        this.FinCbwsMapper.delete(finCbws);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinCbws> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinCbws>) this.FinCbwsMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinCbwsMapper.selectCount(query);
    }

}
