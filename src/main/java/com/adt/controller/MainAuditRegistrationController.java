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

import com.adt.model.MainAuditRegistration;
import com.adt.service.MainAuditRegistrationService;

@RestController
@RequestMapping(value = "/api/mainauditregistration")
public class MainAuditRegistrationController {
    @Resource
    private MainAuditRegistrationService mainAuditRegistrationService;
    
    public static final Logger logger = LoggerFactory.getLogger(MainAuditRegistrationController.class);
     
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
                        .setData(this.mainAuditRegistrationService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.mainAuditRegistrationService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching MainAuditRegistration with id {}", id);
        MainAuditRegistration item = this.mainAuditRegistrationService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<MainAuditRegistration>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All MainAuditRegistration ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<MainAuditRegistration>> filteredListItem() {
        List<MainAuditRegistration> items = this.mainAuditRegistrationService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<MainAuditRegistration>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  MainAuditRegistration ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody MainAuditRegistration item) {
     	logger.info("Creating MainAuditRegistration  : {}", item);
        MainAuditRegistration att = this.mainAuditRegistrationService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.mainAuditRegistrationService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  MainAuditRegistration ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody MainAuditRegistration item) {
		logger.info("Updating MainAuditRegistration with id {}", item.getId());
        this.mainAuditRegistrationService.edit(item);
        return new ResponseEntity< MainAuditRegistration>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a MainAuditRegistration -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody MainAuditRegistration item) throws JSONException {
 		logger.info("Deleting MainAuditRegistration with id {}", item.getId());
        this.mainAuditRegistrationService.remove(item);
        return new ResponseEntity<MainAuditRegistration>(HttpStatus.NO_CONTENT);
    }

}
