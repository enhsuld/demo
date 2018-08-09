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
public class LnkAuditFiles implements Serializable {

    private Integer id;
    private Integer appid;
    private String description;
    private String fcomment;
    private String filename;
    private String fileurl;
    private String fname;
    private Integer fsize;
    private String mimetype;
    
    private Integer firstIndex; 
    private Integer lastIndex; 
    private String searchQuery; 
    private String orderQuery; 

}
