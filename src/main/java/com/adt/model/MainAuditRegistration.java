package com.adt.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import java.io.Serializable;
/**
 * @author Enkhsuld
 */
 
@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MainAuditRegistration implements Serializable {

    private Integer id;
    private Integer a2per;
    private Integer a3per;
    private String aname;
    private Integer aper;
    private String apos;
    private String auditname;
    private String auditors;
    private Integer audityear;
    private Integer autype;
    private String checkers;
    private String chname;
    private String chpos;
    private Integer depid;
    private String director;
    private String dpos;
    private String enddate;
    private String excelurlplan;
    private String excelurlprocess;
    private String gencode;
    private Integer isactive;
    private Integer isenabled;
    private Integer isreport;
    private Integer m2per;
    private Integer m3per;
    private String manager;
    private String matter;
    private Integer mper;
    private String orgcode;
    private Integer orgid;
    private String orgname;
    private Integer orgtype;
    private Integer payroll;
    private Integer regnum;
    private Integer reporttype;
    private String startdate;
    private Integer stepid;
    private Integer t2per;
    private Integer t3per;
    private String terguuleh;
    private Integer tper;
    
    private Integer firstIndex; 
    private Integer lastIndex; 
    private String searchQuery; 
    private String orderQuery; 

}
