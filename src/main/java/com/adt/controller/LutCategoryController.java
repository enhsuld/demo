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

import com.adt.model.LutCategory;
import com.adt.service.LutCategoryService;

@RestController
@RequestMapping(value = "/api/lutcategory")
public class LutCategoryController {
    @Resource
    private LutCategoryService lutCategoryService;
    
    public static final Logger logger = LoggerFactory.getLogger(LutCategoryController.class);
     
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
                        .setData(this.lutCategoryService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lutCategoryService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LutCategory with id {}", id);
        LutCategory item = this.lutCategoryService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LutCategory>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LutCategory ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LutCategory>> filteredListItem() {
        List<LutCategory> items = this.lutCategoryService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LutCategory>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LutCategory ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LutCategory item) {
     	logger.info("Creating LutCategory  : {}", item);
        LutCategory att = this.lutCategoryService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lutCategoryService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LutCategory ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LutCategory item) {
		logger.info("Updating LutCategory with id {}", item.getId());
        this.lutCategoryService.edit(item);
        return new ResponseEntity< LutCategory>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LutCategory -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LutCategory item) throws JSONException {
 		logger.info("Deleting LutCategory with id {}", item.getId());
        this.lutCategoryService.remove(item);
        return new ResponseEntity<LutCategory>(HttpStatus.NO_CONTENT);
    }

}
