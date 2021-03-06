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
public class FinInventory implements Serializable {

    private Integer id;
    private String cyear;
    private String data1;
    private String data10;
    private String data11;
    private String data12;
    private String data2;
    private String data3;
    private String data4;
    private String data5;
    private String data6;
    private String data7;
    private String data8;
    private String data9;
    private Integer orgcatid;
    private String orgcode;
    private Integer planid;
    private Integer stepid;
    
    private Integer firstIndex; 
    private Integer lastIndex; 
    private String searchQuery; 
    private String orderQuery; 

}
