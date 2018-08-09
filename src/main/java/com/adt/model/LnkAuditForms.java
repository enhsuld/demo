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
public class LnkAuditForms implements Serializable {

    private Integer id;
    private Integer appid;
    private String data1;
    private Integer data10;
    private Integer data12;
    private Integer data13;
    private Integer data14;
    private String data2;
    private String data3;
    private Integer data4;
    private Integer data5;
    private Integer data6;
    private String data7;
    private String data8;
    private String data9;
    private Integer formid;
    private Integer levelid;
    private Integer orderid;
    private Integer parentid;
    private Integer stepid;
    
    private Integer firstIndex; 
    private Integer lastIndex; 
    private String searchQuery; 
    private String orderQuery; 

}
