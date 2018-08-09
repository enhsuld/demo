package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinAbwsService;
import com.adt.model.FinAbws;
import com.adt.dao.FinAbwsMapper;

@Service
public class FinAbwsServiceImpl implements FinAbwsService {
    @Resource
    private FinAbwsMapper FinAbwsMapper;

    @Override
    public List<FinAbws> find(FinAbws finAbws) {
        return this.FinAbwsMapper.list(finAbws);
    }

    @Override
    public FinAbws view(FinAbws finAbws) {
        return this.FinAbwsMapper.select(finAbws);
    }
    
    @Override
    public List<FinAbws> findAll() {
        return this.FinAbwsMapper.findAll();
    }

    @Override
    public FinAbws findById(String id) {
        return this.FinAbwsMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinAbws finAbws) {
        this.FinAbwsMapper.insert(finAbws);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinAbws finAbws) {
        this.FinAbwsMapper.update(finAbws);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinAbws finAbws) {
        this.FinAbwsMapper.delete(finAbws);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinAbws> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinAbws>) this.FinAbwsMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinAbwsMapper.selectCount(query);
    }

}
