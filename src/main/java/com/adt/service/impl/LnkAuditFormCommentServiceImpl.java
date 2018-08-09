package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LnkAuditFormCommentService;
import com.adt.model.LnkAuditFormComment;
import com.adt.dao.LnkAuditFormCommentMapper;

@Service
public class LnkAuditFormCommentServiceImpl implements LnkAuditFormCommentService {
    @Resource
    private LnkAuditFormCommentMapper LnkAuditFormCommentMapper;

    @Override
    public List<LnkAuditFormComment> find(LnkAuditFormComment lnkAuditFormComment) {
        return this.LnkAuditFormCommentMapper.list(lnkAuditFormComment);
    }

    @Override
    public LnkAuditFormComment view(LnkAuditFormComment lnkAuditFormComment) {
        return this.LnkAuditFormCommentMapper.select(lnkAuditFormComment);
    }
    
    @Override
    public List<LnkAuditFormComment> findAll() {
        return this.LnkAuditFormCommentMapper.findAll();
    }

    @Override
    public LnkAuditFormComment findById(String id) {
        return this.LnkAuditFormCommentMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LnkAuditFormComment lnkAuditFormComment) {
        this.LnkAuditFormCommentMapper.insert(lnkAuditFormComment);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LnkAuditFormComment lnkAuditFormComment) {
        this.LnkAuditFormCommentMapper.update(lnkAuditFormComment);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LnkAuditFormComment lnkAuditFormComment) {
        this.LnkAuditFormCommentMapper.delete(lnkAuditFormComment);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LnkAuditFormComment> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LnkAuditFormComment>) this.LnkAuditFormCommentMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LnkAuditFormCommentMapper.selectCount(query);
    }

}
