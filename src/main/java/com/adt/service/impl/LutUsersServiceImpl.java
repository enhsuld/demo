package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LutUsersService;
import com.adt.model.LutUsers;
import com.adt.dao.LutUsersMapper;

@Service
public class LutUsersServiceImpl implements LutUsersService {
    @Resource
    private LutUsersMapper LutUsersMapper;

    @Override
    public List<LutUsers> find(LutUsers lutUsers) {
        return this.LutUsersMapper.list(lutUsers);
    }

    @Override
    public LutUsers view(LutUsers lutUsers) {
        return this.LutUsersMapper.select(lutUsers);
    }
    
    @Override
    public List<LutUsers> findAll() {
        return this.LutUsersMapper.findAll();
    }

    @Override
    public LutUsers findById(String id) {
        return this.LutUsersMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LutUsers lutUsers) {
        this.LutUsersMapper.insert(lutUsers);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LutUsers lutUsers) {
        this.LutUsersMapper.update(lutUsers);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LutUsers lutUsers) {
        this.LutUsersMapper.delete(lutUsers);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LutUsers> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LutUsers>) this.LutUsersMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LutUsersMapper.selectCount(query);
    }

}
