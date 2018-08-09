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

import com.adt.model.LnkAuditFormComment;
import com.adt.service.LnkAuditFormCommentService;

@RestController
@RequestMapping(value = "/api/lnkauditformcomment")
public class LnkAuditFormCommentController {
    @Resource
    private LnkAuditFormCommentService lnkAuditFormCommentService;
    
    public static final Logger logger = LoggerFactory.getLogger(LnkAuditFormCommentController.class);
     
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
                        .setData(this.lnkAuditFormCommentService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lnkAuditFormCommentService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LnkAuditFormComment with id {}", id);
        LnkAuditFormComment item = this.lnkAuditFormCommentService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LnkAuditFormComment>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LnkAuditFormComment ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LnkAuditFormComment>> filteredListItem() {
        List<LnkAuditFormComment> items = this.lnkAuditFormCommentService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LnkAuditFormComment>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LnkAuditFormComment ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LnkAuditFormComment item) {
     	logger.info("Creating LnkAuditFormComment  : {}", item);
        LnkAuditFormComment att = this.lnkAuditFormCommentService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lnkAuditFormCommentService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LnkAuditFormComment ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LnkAuditFormComment item) {
		logger.info("Updating LnkAuditFormComment with id {}", item.getId());
        this.lnkAuditFormCommentService.edit(item);
        return new ResponseEntity< LnkAuditFormComment>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LnkAuditFormComment -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LnkAuditFormComment item) throws JSONException {
 		logger.info("Deleting LnkAuditFormComment with id {}", item.getId());
        this.lnkAuditFormCommentService.remove(item);
        return new ResponseEntity<LnkAuditFormComment>(HttpStatus.NO_CONTENT);
    }

}
