package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LnkMainUsersService;
import com.adt.model.LnkMainUsers;
import com.adt.dao.LnkMainUsersMapper;

@Service
public class LnkMainUsersServiceImpl implements LnkMainUsersService {
    @Resource
    private LnkMainUsersMapper LnkMainUsersMapper;

    @Override
    public List<LnkMainUsers> find(LnkMainUsers lnkMainUsers) {
        return this.LnkMainUsersMapper.list(lnkMainUsers);
    }

    @Override
    public LnkMainUsers view(LnkMainUsers lnkMainUsers) {
        return this.LnkMainUsersMapper.select(lnkMainUsers);
    }
    
    @Override
    public List<LnkMainUsers> findAll() {
        return this.LnkMainUsersMapper.findAll();
    }

    @Override
    public LnkMainUsers findById(String id) {
        return this.LnkMainUsersMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LnkMainUsers lnkMainUsers) {
        this.LnkMainUsersMapper.insert(lnkMainUsers);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LnkMainUsers lnkMainUsers) {
        this.LnkMainUsersMapper.update(lnkMainUsers);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LnkMainUsers lnkMainUsers) {
        this.LnkMainUsersMapper.delete(lnkMainUsers);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LnkMainUsers> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LnkMainUsers>) this.LnkMainUsersMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LnkMainUsersMapper.selectCount(query);
    }

}
