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
public class LnkDepartmentPlan implements Serializable {

    private Integer id;
    private Integer auditCount;
    private String createDate;
    private Integer orgid;
    private Integer planid;
    
    private Integer firstIndex; 
    private Integer lastIndex; 
    private String searchQuery; 
    private String orderQuery; 

}
