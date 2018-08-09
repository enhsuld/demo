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

import com.adt.model.LnkDepartmentPlan;
import com.adt.service.LnkDepartmentPlanService;

@RestController
@RequestMapping(value = "/api/lnkdepartmentplan")
public class LnkDepartmentPlanController {
    @Resource
    private LnkDepartmentPlanService lnkDepartmentPlanService;
    
    public static final Logger logger = LoggerFactory.getLogger(LnkDepartmentPlanController.class);
     
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
                        .setData(this.lnkDepartmentPlanService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lnkDepartmentPlanService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LnkDepartmentPlan with id {}", id);
        LnkDepartmentPlan item = this.lnkDepartmentPlanService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LnkDepartmentPlan>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LnkDepartmentPlan ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LnkDepartmentPlan>> filteredListItem() {
        List<LnkDepartmentPlan> items = this.lnkDepartmentPlanService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LnkDepartmentPlan>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LnkDepartmentPlan ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LnkDepartmentPlan item) {
     	logger.info("Creating LnkDepartmentPlan  : {}", item);
        LnkDepartmentPlan att = this.lnkDepartmentPlanService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lnkDepartmentPlanService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LnkDepartmentPlan ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LnkDepartmentPlan item) {
		logger.info("Updating LnkDepartmentPlan with id {}", item.getId());
        this.lnkDepartmentPlanService.edit(item);
        return new ResponseEntity< LnkDepartmentPlan>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LnkDepartmentPlan -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LnkDepartmentPlan item) throws JSONException {
 		logger.info("Deleting LnkDepartmentPlan with id {}", item.getId());
        this.lnkDepartmentPlanService.remove(item);
        return new ResponseEntity<LnkDepartmentPlan>(HttpStatus.NO_CONTENT);
    }

}
