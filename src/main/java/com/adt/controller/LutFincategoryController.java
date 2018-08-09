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

import com.adt.model.LutFincategory;
import com.adt.service.LutFincategoryService;

@RestController
@RequestMapping(value = "/api/lutfincategory")
public class LutFincategoryController {
    @Resource
    private LutFincategoryService lutFincategoryService;
    
    public static final Logger logger = LoggerFactory.getLogger(LutFincategoryController.class);
     
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
                        .setData(this.lutFincategoryService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lutFincategoryService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LutFincategory with id {}", id);
        LutFincategory item = this.lutFincategoryService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LutFincategory>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LutFincategory ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LutFincategory>> filteredListItem() {
        List<LutFincategory> items = this.lutFincategoryService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LutFincategory>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LutFincategory ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LutFincategory item) {
     	logger.info("Creating LutFincategory  : {}", item);
        LutFincategory att = this.lutFincategoryService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lutFincategoryService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LutFincategory ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LutFincategory item) {
		logger.info("Updating LutFincategory with id {}", item.getId());
        this.lutFincategoryService.edit(item);
        return new ResponseEntity< LutFincategory>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LutFincategory -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LutFincategory item) throws JSONException {
 		logger.info("Deleting LutFincategory with id {}", item.getId());
        this.lutFincategoryService.remove(item);
        return new ResponseEntity<LutFincategory>(HttpStatus.NO_CONTENT);
    }

}
