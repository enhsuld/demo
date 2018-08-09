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

import com.adt.model.FinInventory;
import com.adt.service.FinInventoryService;

@RestController
@RequestMapping(value = "/api/fininventory")
public class FinInventoryController {
    @Resource
    private FinInventoryService finInventoryService;
    
    public static final Logger logger = LoggerFactory.getLogger(FinInventoryController.class);
     
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
                        .setData(this.finInventoryService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finInventoryService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinInventory with id {}", id);
        FinInventory item = this.finInventoryService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinInventory>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinInventory ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinInventory>> filteredListItem() {
        List<FinInventory> items = this.finInventoryService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinInventory>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinInventory ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinInventory item) {
     	logger.info("Creating FinInventory  : {}", item);
        FinInventory att = this.finInventoryService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finInventoryService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinInventory ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinInventory item) {
		logger.info("Updating FinInventory with id {}", item.getId());
        this.finInventoryService.edit(item);
        return new ResponseEntity< FinInventory>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinInventory -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinInventory item) throws JSONException {
 		logger.info("Deleting FinInventory with id {}", item.getId());
        this.finInventoryService.remove(item);
        return new ResponseEntity<FinInventory>(HttpStatus.NO_CONTENT);
    }

}
