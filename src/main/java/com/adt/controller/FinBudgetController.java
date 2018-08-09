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

import com.adt.model.FinBudget;
import com.adt.service.FinBudgetService;

@RestController
@RequestMapping(value = "/api/finbudget")
public class FinBudgetController {
    @Resource
    private FinBudgetService finBudgetService;
    
    public static final Logger logger = LoggerFactory.getLogger(FinBudgetController.class);
     
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
                        .setData(this.finBudgetService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finBudgetService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinBudget with id {}", id);
        FinBudget item = this.finBudgetService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinBudget>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinBudget ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinBudget>> filteredListItem() {
        List<FinBudget> items = this.finBudgetService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinBudget>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinBudget ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinBudget item) {
     	logger.info("Creating FinBudget  : {}", item);
        FinBudget att = this.finBudgetService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finBudgetService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinBudget ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinBudget item) {
		logger.info("Updating FinBudget with id {}", item.getId());
        this.finBudgetService.edit(item);
        return new ResponseEntity< FinBudget>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinBudget -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinBudget item) throws JSONException {
 		logger.info("Deleting FinBudget with id {}", item.getId());
        this.finBudgetService.remove(item);
        return new ResponseEntity<FinBudget>(HttpStatus.NO_CONTENT);
    }

}
