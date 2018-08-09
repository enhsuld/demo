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

import com.adt.model.FinTrialBalance;
import com.adt.service.FinTrialBalanceService;

@RestController
@RequestMapping(value = "/api/fintrialbalance")
public class FinTrialBalanceController {
    @Resource
    private FinTrialBalanceService finTrialBalanceService;
    
    public static final Logger logger = LoggerFactory.getLogger(FinTrialBalanceController.class);
     
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
                        .setData(this.finTrialBalanceService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finTrialBalanceService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinTrialBalance with id {}", id);
        FinTrialBalance item = this.finTrialBalanceService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinTrialBalance>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinTrialBalance ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinTrialBalance>> filteredListItem() {
        List<FinTrialBalance> items = this.finTrialBalanceService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinTrialBalance>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinTrialBalance ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinTrialBalance item) {
     	logger.info("Creating FinTrialBalance  : {}", item);
        FinTrialBalance att = this.finTrialBalanceService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finTrialBalanceService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinTrialBalance ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinTrialBalance item) {
		logger.info("Updating FinTrialBalance with id {}", item.getId());
        this.finTrialBalanceService.edit(item);
        return new ResponseEntity< FinTrialBalance>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinTrialBalance -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinTrialBalance item) throws JSONException {
 		logger.info("Deleting FinTrialBalance with id {}", item.getId());
        this.finTrialBalanceService.remove(item);
        return new ResponseEntity<FinTrialBalance>(HttpStatus.NO_CONTENT);
    }

}
