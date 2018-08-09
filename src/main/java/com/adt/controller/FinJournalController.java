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

import com.adt.model.FinJournal;
import com.adt.service.FinJournalService;

@RestController
@RequestMapping(value = "/api/finjournal")
public class FinJournalController {
    @Resource
    private FinJournalService finJournalService;
    
    public static final Logger logger = LoggerFactory.getLogger(FinJournalController.class);
     
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
                        .setData(this.finJournalService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finJournalService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinJournal with id {}", id);
        FinJournal item = this.finJournalService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinJournal>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinJournal ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinJournal>> filteredListItem() {
        List<FinJournal> items = this.finJournalService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinJournal>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinJournal ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinJournal item) {
     	logger.info("Creating FinJournal  : {}", item);
        FinJournal att = this.finJournalService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finJournalService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinJournal ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinJournal item) {
		logger.info("Updating FinJournal with id {}", item.getId());
        this.finJournalService.edit(item);
        return new ResponseEntity< FinJournal>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinJournal -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinJournal item) throws JSONException {
 		logger.info("Deleting FinJournal with id {}", item.getId());
        this.finJournalService.remove(item);
        return new ResponseEntity<FinJournal>(HttpStatus.NO_CONTENT);
    }

}
