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
public class LutCategory implements Serializable {

    private Integer id;
    private String categoryname;
    
    private Integer firstIndex; 
    private Integer lastIndex; 
    private String searchQuery; 
    private String orderQuery; 

}
