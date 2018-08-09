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
public class FileUpload implements Serializable {

    private Integer id;
    private Integer aan;
    private Integer autype;
    private String filename;
    private String filenameAdmin;
    private Integer filesize;
    private Integer filesizeAdmin;
    private String fileurl;
    private String fileurlAdmin;
    private String mimetype;
    private String mimetypeAdmin;
    private String name;
    private String nameAdmin;
    private Integer payroll;
    
    private Integer firstIndex; 
    private Integer lastIndex; 
    private String searchQuery; 
    private String orderQuery; 

}
