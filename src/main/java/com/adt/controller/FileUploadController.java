package com.adt.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.adt.constant.PaginatedResult;
import com.adt.constant.QueryBuilder;

import com.adt.model.FileUpload;
import com.adt.service.FileUploadService;

@RestController
@RequestMapping(value = "/api/fileupload")
public class FileUploadController {
    @Resource
    private FileUploadService fileUploadService;
    
    public static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
     
    @Resource
    private QueryBuilder builder;

    // -------------------List by page ----------------------------------------------------------
     
    @PostMapping("/list")
    public ResponseEntity<?> getList(@RequestBody String data) throws JSONException {
        String query="";


        JSONObject obj= new JSONObject(data);
        String order="";
        if(obj.has("sort")){
            order=builder.getSort(data);
        }
        if(obj.has("filter")){
            query=builder.getFilter(data);
        }

        return ResponseEntity
                .ok(new PaginatedResult()
                        .setData(this.fileUploadService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.fileUploadService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FileUpload with id {}", id);
        FileUpload item = this.fileUploadService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FileUpload>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FileUpload ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FileUpload>> filteredListItem() {
        List<FileUpload> items = this.fileUploadService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FileUpload>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FileUpload ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FileUpload item) {
     	logger.info("Creating FileUpload  : {}", item);
        FileUpload att = this.fileUploadService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.fileUploadService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FileUpload ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FileUpload item) {
		logger.info("Updating FileUpload with id {}", item.getId());
        this.fileUploadService.edit(item);
        return new ResponseEntity< FileUpload>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FileUpload -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FileUpload item) throws JSONException {
 		logger.info("Deleting FileUpload with id {}", item.getId());
        this.fileUploadService.remove(item);
        return new ResponseEntity<FileUpload>(HttpStatus.NO_CONTENT);
    }

}
