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

import com.adt.model.LutReason;
import com.adt.service.LutReasonService;

@RestController
@RequestMapping(value = "/api/lutreason")
public class LutReasonController {
    @Resource
    private LutReasonService lutReasonService;
    
    public static final Logger logger = LoggerFactory.getLogger(LutReasonController.class);
     
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
                        .setData(this.lutReasonService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lutReasonService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LutReason with id {}", id);
        LutReason item = this.lutReasonService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LutReason>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LutReason ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LutReason>> filteredListItem() {
        List<LutReason> items = this.lutReasonService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LutReason>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LutReason ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LutReason item) {
     	logger.info("Creating LutReason  : {}", item);
        LutReason att = this.lutReasonService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lutReasonService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LutReason ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LutReason item) {
		logger.info("Updating LutReason with id {}", item.getId());
        this.lutReasonService.edit(item);
        return new ResponseEntity< LutReason>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LutReason -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LutReason item) throws JSONException {
 		logger.info("Deleting LutReason with id {}", item.getId());
        this.lutReasonService.remove(item);
        return new ResponseEntity<LutReason>(HttpStatus.NO_CONTENT);
    }

}
