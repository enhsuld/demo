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
public class LnkUserrole implements Serializable {

    private Integer id;
    private Integer roleid;
    private Integer userid;
    
    private Integer firstIndex; 
    private Integer lastIndex; 
    private String searchQuery; 
    private String orderQuery; 

}
