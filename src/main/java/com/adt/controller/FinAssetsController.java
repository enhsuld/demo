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

import com.adt.model.FinAssets;
import com.adt.service.FinAssetsService;

@RestController
@RequestMapping(value = "/api/finassets")
public class FinAssetsController {
    @Resource
    private FinAssetsService finAssetsService;
    
    public static final Logger logger = LoggerFactory.getLogger(FinAssetsController.class);
     
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
                        .setData(this.finAssetsService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finAssetsService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinAssets with id {}", id);
        FinAssets item = this.finAssetsService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinAssets>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinAssets ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinAssets>> filteredListItem() {
        List<FinAssets> items = this.finAssetsService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinAssets>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinAssets ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinAssets item) {
     	logger.info("Creating FinAssets  : {}", item);
        FinAssets att = this.finAssetsService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finAssetsService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinAssets ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinAssets item) {
		logger.info("Updating FinAssets with id {}", item.getId());
        this.finAssetsService.edit(item);
        return new ResponseEntity< FinAssets>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinAssets -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinAssets item) throws JSONException {
 		logger.info("Deleting FinAssets with id {}", item.getId());
        this.finAssetsService.remove(item);
        return new ResponseEntity<FinAssets>(HttpStatus.NO_CONTENT);
    }

}
