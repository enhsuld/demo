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

import com.adt.model.LutPosition;
import com.adt.service.LutPositionService;

@RestController
@RequestMapping(value = "/api/lutposition")
public class LutPositionController {
    @Resource
    private LutPositionService lutPositionService;
    
    public static final Logger logger = LoggerFactory.getLogger(LutPositionController.class);
     
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
                        .setData(this.lutPositionService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lutPositionService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LutPosition with id {}", id);
        LutPosition item = this.lutPositionService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LutPosition>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LutPosition ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LutPosition>> filteredListItem() {
        List<LutPosition> items = this.lutPositionService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LutPosition>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LutPosition ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LutPosition item) {
     	logger.info("Creating LutPosition  : {}", item);
        LutPosition att = this.lutPositionService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lutPositionService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LutPosition ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LutPosition item) {
		logger.info("Updating LutPosition with id {}", item.getId());
        this.lutPositionService.edit(item);
        return new ResponseEntity< LutPosition>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LutPosition -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LutPosition item) throws JSONException {
 		logger.info("Deleting LutPosition with id {}", item.getId());
        this.lutPositionService.remove(item);
        return new ResponseEntity<LutPosition>(HttpStatus.NO_CONTENT);
    }

}
