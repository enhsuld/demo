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

import com.adt.model.FinAbws;
import com.adt.service.FinAbwsService;

@RestController
@RequestMapping(value = "/api/finabws")
public class FinAbwsController {
    @Resource
    private FinAbwsService finAbwsService;
    
    public static final Logger logger = LoggerFactory.getLogger(FinAbwsController.class);
     
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
                        .setData(this.finAbwsService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finAbwsService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinAbws with id {}", id);
        FinAbws item = this.finAbwsService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinAbws>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinAbws ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinAbws>> filteredListItem() {
        List<FinAbws> items = this.finAbwsService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinAbws>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinAbws ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinAbws item) {
     	logger.info("Creating FinAbws  : {}", item);
        FinAbws att = this.finAbwsService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finAbwsService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinAbws ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinAbws item) {
		logger.info("Updating FinAbws with id {}", item.getId());
        this.finAbwsService.edit(item);
        return new ResponseEntity< FinAbws>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinAbws -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinAbws item) throws JSONException {
 		logger.info("Deleting FinAbws with id {}", item.getId());
        this.finAbwsService.remove(item);
        return new ResponseEntity<FinAbws>(HttpStatus.NO_CONTENT);
    }

}
