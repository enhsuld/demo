package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LnkOrgyplanreport;

@Mapper
public interface LnkOrgyplanreportMapper {
    public List<LnkOrgyplanreport> list(LnkOrgyplanreport lnkOrgyplanreport);
    public LnkOrgyplanreport select(LnkOrgyplanreport lnkOrgyplanreport);
    public void insert(LnkOrgyplanreport lnkOrgyplanreport);
    public void update(LnkOrgyplanreport lnkOrgyplanreport);
    public void delete(LnkOrgyplanreport lnkOrgyplanreport);
    public List<LnkOrgyplanreport> findAll();
    public LnkOrgyplanreport findById(String id);
    
    public List<LnkOrgyplanreport> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
