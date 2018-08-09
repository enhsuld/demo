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
public class SubAuditOrganizations implements Serializable {

    private Integer id;
    private String accemail;
    private String accfullname;
    private String accphone;
    private String accpos;
    private String accprof;
    private String accsurname;
    private String accwyear;
    private String address;
    private String aimagname;
    private Integer auditresult1;
    private Integer auditresult2;
    private Integer auditresult3;
    private String banks;
    private Integer categoryid;
    private String comwnum;
    private String conwnum;
    private String createdate;
    private Integer departmentid;
    private String email;
    private String fax;
    private Integer fincategoryid;
    private String fsorg;
    private String heademail;
    private String headfullname;
    private String headorder;
    private String headphone;
    private String headpos;
    private String headprof;
    private String headreg;
    private String headsurname;
    private String headwnum;
    private String headwyear;
    private String ndorg;
    private String orgcode;
    private String orgname;
    private String otherwnum;
    private String owndir;
    private String parentid;
    private String phone;
    private String plan1;
    private String plan2;
    private String plan3;
    private Integer progid;
    private Integer regid;
    private String report1;
    private String report2;
    private String report3;
    private String serwnum;
    private String soumname;
    private String statebanks;
    private String statedir;
    private String stateregid;
    private String taxorg;
    private String web;
    
    private Integer firstIndex; 
    private Integer lastIndex; 
    private String searchQuery; 
    private String orderQuery; 

}
