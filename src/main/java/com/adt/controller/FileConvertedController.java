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

import com.adt.model.FileConverted;
import com.adt.service.FileConvertedService;

@RestController
@RequestMapping(value = "/api/fileconverted")
public class FileConvertedController {
    @Resource
    private FileConvertedService fileConvertedService;
    
    public static final Logger logger = LoggerFactory.getLogger(FileConvertedController.class);
     
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
                        .setData(this.fileConvertedService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.fileConvertedService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FileConverted with id {}", id);
        FileConverted item = this.fileConvertedService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FileConverted>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FileConverted ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FileConverted>> filteredListItem() {
        List<FileConverted> items = this.fileConvertedService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FileConverted>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FileConverted ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FileConverted item) {
     	logger.info("Creating FileConverted  : {}", item);
        FileConverted att = this.fileConvertedService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.fileConvertedService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FileConverted ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FileConverted item) {
		logger.info("Updating FileConverted with id {}", item.getId());
        this.fileConvertedService.edit(item);
        return new ResponseEntity< FileConverted>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FileConverted -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FileConverted item) throws JSONException {
 		logger.info("Deleting FileConverted with id {}", item.getId());
        this.fileConvertedService.remove(item);
        return new ResponseEntity<FileConverted>(HttpStatus.NO_CONTENT);
    }

}
