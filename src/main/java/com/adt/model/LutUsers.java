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
public class LutUsers implements Serializable {

    private Integer id;
    private Integer autype;
    private Integer departmentid;
    private String email;
    private String familyname;
    private String givenname;
    private Integer isactive;
    private Integer iscompany;
    private String mobile;
    private String password;
    private Integer positionid;
    private String roleid;
    private String username;
    
    private Integer firstIndex; 
    private Integer lastIndex; 
    private String searchQuery; 
    private String orderQuery; 

}
