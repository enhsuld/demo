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

import com.adt.model.LutDepartments;
import com.adt.service.LutDepartmentsService;

@RestController
@RequestMapping(value = "/api/lutdepartments")
public class LutDepartmentsController {
    @Resource
    private LutDepartmentsService lutDepartmentsService;
    
    public static final Logger logger = LoggerFactory.getLogger(LutDepartmentsController.class);
     
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
                        .setData(this.lutDepartmentsService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lutDepartmentsService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LutDepartments with id {}", id);
        LutDepartments item = this.lutDepartmentsService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LutDepartments>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LutDepartments ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LutDepartments>> filteredListItem() {
        List<LutDepartments> items = this.lutDepartmentsService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LutDepartments>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LutDepartments ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LutDepartments item) {
     	logger.info("Creating LutDepartments  : {}", item);
        LutDepartments att = this.lutDepartmentsService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lutDepartmentsService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LutDepartments ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LutDepartments item) {
		logger.info("Updating LutDepartments with id {}", item.getId());
        this.lutDepartmentsService.edit(item);
        return new ResponseEntity< LutDepartments>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LutDepartments -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LutDepartments item) throws JSONException {
 		logger.info("Deleting LutDepartments with id {}", item.getId());
        this.lutDepartmentsService.remove(item);
        return new ResponseEntity<LutDepartments>(HttpStatus.NO_CONTENT);
    }

}
