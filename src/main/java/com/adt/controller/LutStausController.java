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

import com.adt.model.LutStaus;
import com.adt.service.LutStausService;

@RestController
@RequestMapping(value = "/api/lutstaus")
public class LutStausController {
    @Resource
    private LutStausService lutStausService;
    
    public static final Logger logger = LoggerFactory.getLogger(LutStausController.class);
     
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
                        .setData(this.lutStausService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lutStausService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LutStaus with id {}", id);
        LutStaus item = this.lutStausService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LutStaus>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LutStaus ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LutStaus>> filteredListItem() {
        List<LutStaus> items = this.lutStausService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LutStaus>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LutStaus ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LutStaus item) {
     	logger.info("Creating LutStaus  : {}", item);
        LutStaus att = this.lutStausService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lutStausService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LutStaus ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LutStaus item) {
		logger.info("Updating LutStaus with id {}", item.getId());
        this.lutStausService.edit(item);
        return new ResponseEntity< LutStaus>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LutStaus -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LutStaus item) throws JSONException {
 		logger.info("Deleting LutStaus with id {}", item.getId());
        this.lutStausService.remove(item);
        return new ResponseEntity<LutStaus>(HttpStatus.NO_CONTENT);
    }

}
