package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinTrialBalanceService;
import com.adt.model.FinTrialBalance;
import com.adt.dao.FinTrialBalanceMapper;

@Service
public class FinTrialBalanceServiceImpl implements FinTrialBalanceService {
    @Resource
    private FinTrialBalanceMapper FinTrialBalanceMapper;

    @Override
    public List<FinTrialBalance> find(FinTrialBalance finTrialBalance) {
        return this.FinTrialBalanceMapper.list(finTrialBalance);
    }

    @Override
    public FinTrialBalance view(FinTrialBalance finTrialBalance) {
        return this.FinTrialBalanceMapper.select(finTrialBalance);
    }
    
    @Override
    public List<FinTrialBalance> findAll() {
        return this.FinTrialBalanceMapper.findAll();
    }

    @Override
    public FinTrialBalance findById(String id) {
        return this.FinTrialBalanceMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinTrialBalance finTrialBalance) {
        this.FinTrialBalanceMapper.insert(finTrialBalance);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinTrialBalance finTrialBalance) {
        this.FinTrialBalanceMapper.update(finTrialBalance);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinTrialBalance finTrialBalance) {
        this.FinTrialBalanceMapper.delete(finTrialBalance);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinTrialBalance> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinTrialBalance>) this.FinTrialBalanceMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinTrialBalanceMapper.selectCount(query);
    }

}
