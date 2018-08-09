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
public class LnkAuditProblems implements Serializable {

    private Integer id;
    private String acc;
    private Integer accCode;
    private Integer isActive;
    private String aktName;
    private String aktZaalt;
    private Integer amount;
    private Integer answer;
    private Integer appid;
    private String comAktName;
    private String comAktZaalt;
    private Integer comAmount;
    private Integer comMatter;
    private Integer comResult;
    private Integer commentType;
    private String finDate;
    private Integer finalAktAmount;
    private Integer finalAmount;
    private Integer finalAshAmount;
    private Integer finalAdvAmount;
    private Integer finish;
    private String insDate;
    private Integer isMatter;
    private String offerDate;
    private String problem;
    private Integer reportId;
    private Integer result;
    private Integer stepid;
    
    private Integer firstIndex; 
    private Integer lastIndex; 
    private String searchQuery; 
    private String orderQuery; 

}
