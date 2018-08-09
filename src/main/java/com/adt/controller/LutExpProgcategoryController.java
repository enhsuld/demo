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

import com.adt.model.LutExpProgcategory;
import com.adt.service.LutExpProgcategoryService;

@RestController
@RequestMapping(value = "/api/lutexpprogcategory")
public class LutExpProgcategoryController {
    @Resource
    private LutExpProgcategoryService lutExpProgcategoryService;
    
    public static final Logger logger = LoggerFactory.getLogger(LutExpProgcategoryController.class);
     
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
                        .setData(this.lutExpProgcategoryService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lutExpProgcategoryService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LutExpProgcategory with id {}", id);
        LutExpProgcategory item = this.lutExpProgcategoryService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LutExpProgcategory>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LutExpProgcategory ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LutExpProgcategory>> filteredListItem() {
        List<LutExpProgcategory> items = this.lutExpProgcategoryService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LutExpProgcategory>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LutExpProgcategory ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LutExpProgcategory item) {
     	logger.info("Creating LutExpProgcategory  : {}", item);
        LutExpProgcategory att = this.lutExpProgcategoryService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lutExpProgcategoryService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LutExpProgcategory ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LutExpProgcategory item) {
		logger.info("Updating LutExpProgcategory with id {}", item.getId());
        this.lutExpProgcategoryService.edit(item);
        return new ResponseEntity< LutExpProgcategory>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LutExpProgcategory -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LutExpProgcategory item) throws JSONException {
 		logger.info("Deleting LutExpProgcategory with id {}", item.getId());
        this.lutExpProgcategoryService.remove(item);
        return new ResponseEntity<LutExpProgcategory>(HttpStatus.NO_CONTENT);
    }

}
