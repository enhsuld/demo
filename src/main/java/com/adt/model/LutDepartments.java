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
public class LutDepartments implements Serializable {

    private Integer id;
    private String address;
    private Integer auditCount;
    private Integer autype;
    private String departmentname;
    private String email;
    private Integer isactive;
    private Integer ismultiple;
    private Integer isstate;
    private String licexpiredate;
    private String licnum;
    private Integer parentid;
    private String phone;
    private Integer plan;
    private Integer reg;
    private String shortname;
    private String web;
    
    private Integer firstIndex; 
    private Integer lastIndex; 
    private String searchQuery; 
    private String orderQuery; 

}
