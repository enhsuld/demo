package com.adt.constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.*;


@Component
public class QueryBuilder {

     public String getSort(String request) throws JSONException {
        String field = "";
        String order = "";
        String multiOrde = "";
        String dir = "";
        JSONObject obj = new JSONObject(request);
        JSONArray arr = obj.getJSONArray("sort");
        for (int i = 0; i < arr.length(); i++) {
            String str = arr.get(i).toString();
            JSONObject srt = new JSONObject(str);
            if (srt.isNull("field")) {
                field = "";
            } else {
                field = srt.getString("field");
                String replaceString = field.replaceAll("([A-Z]+)", "\\_$1").toLowerCase();
                multiOrde = multiOrde + " " + replaceString;

            }
            if (srt.isNull("dir")) {
                dir = "";
            } else {
                dir = srt.getString("dir");
                multiOrde = multiOrde + " " + dir + ",";
            }
        }
        if(multiOrde.length()>0){
            order = "order by " + multiOrde.substring(0, multiOrde.length() - 1) + "";
        }


        return order;
    }

    public String getFilter(String request) throws JSONException {

        JSONObject filter = null;
        String flquery = "";
        JSONObject req = new JSONObject(request);
        String operator = "";
        String value = "";
        if (req.has("filter")) {
            if (!req.isNull("filter")) {
                if (req.getJSONObject("filter").has("logic")) {
                    filter = req.getJSONObject("filter");
                }
            }
        }
        String filterfield = "";
        if (filter != null) {

            JSONObject fltr = filter;
            String logic = fltr.getString("logic");
            JSONArray arr = fltr.getJSONArray("filters");
            for (int i = 0; i < arr.length(); i++) {
                String str = arr.get(i).toString();
                JSONObject srt = new JSONObject(str);
                if (srt.isNull("field")) {
                    filterfield = "";
                } else {
                    filterfield = srt.getString("field").replaceAll("([A-Z]+)", "\\_$1").toLowerCase();
                }
                if (srt.isNull("operator")) {
                    operator = "";
                } else {
                    operator = srt.getString("operator");
                }
                if (srt.isNull("value")) {
                    value = "";
                } else {
                    value = String.valueOf(srt.get("value"));
                    if(value.length()==5 && value.equalsIgnoreCase("false")){
                        value="N";
                    }
                    if(value.length()==4 && value.equalsIgnoreCase("true")){
                        value="Y";
                    }
                }
                if (value.length() >= 1) {
                    if (i > 0) {
                        switch (operator) {
                            case "startswith":
                                flquery = flquery + " " + logic + " lower(" + filterfield + ") LIKE lower('" + value + "%')";
                                break;
                            case "contains":
                                flquery = flquery + " " + logic + " lower(" + filterfield + ") LIKE lower('%" + value + "%')";
                                break;
                            case "doesnotcontain":
                                flquery = flquery + " " + logic + " lower(" + filterfield + ") NOT LIKE lower('%" + value + "%')";
                                break;
                            case "endswith":
                                flquery = flquery + " " + logic + " lower(" + filterfield + ") LIKE lower('%" + value + "')";
                                break;
                            case "neq":
                                flquery = flquery + " " + logic + " lower(" + filterfield + ") != lower('" + value + "')";
                                break;
                            case "eq":
                                flquery = flquery + " " + logic + " lower(" + filterfield + ") = lower('" + value + "')";
                                break;
                            case "gte":
                                flquery = flquery + " " + logic + " " + filterfield + " >= '" + value + "'";
                                break;
                            case "lte":
                                flquery = flquery + " " + logic + " " + filterfield + " <= '" + value + "'";
                                break;
                            case "nlike":
                                flquery = flquery + " " + logic + " " + filterfield + " LIKE ('" + value + "%')";
                                break;
                            case "leq":
                                flquery = flquery + " " + logic + " " + filterfield + " = '" + value + "'";
                                break;
                            case "lj":
                                flquery = flquery + " " + logic + " " + filterfield + " (+)= '" + value + "'";
                                break;
                            case "rj":
                                flquery = flquery + " " + logic + " " + filterfield + " =(+) '" + value + "'";
                                break;
                            case "length":
                                flquery = flquery + " " + logic + " " + filterfield + " = length('" + value + "')";
                                break;
                            case "lengthReverse":
                                flquery = flquery + " " + logic + " length(" + filterfield + ") = '" + value + "'";
                                break;
                            case "lengthGte":
                                flquery = flquery + " " + logic + " length(" + filterfield + ") >= '" + value + "'";
                                break;
                            case "ids":
                                flquery = flquery + " " + logic + " " + filterfield + " in (" + value + ")";
                                break;
                            case "in":

                                if(value.length() >1){
                                    String[] list = value.substring(1, value.length() - 1).split(",");
                                    if(list.length>0){
                                        String ids = "";
                                        for (String st : list) {
                                            if(st.length()>1){
                                                ids = ids + "','" + st.substring(1, st.length() - 1);
                                            }
                                        }
                                        if(ids.length()>2){
                                            flquery = flquery + " " + logic + " " + filterfield + " in (" + ids.substring(2, ids.length()) + "')";
                                        }
                                    }
                                }
                                else{
                                    flquery = flquery + " " + logic + " " + filterfield + " in ('" + value + "')";
                                }
                                break;
                            case "isNull":
                                flquery = flquery + " " + logic + " " + filterfield + " is null";
                                break;
                            case "notNull":
                                flquery = flquery + " " + logic + " " + filterfield + " is not null";
                                break;



                        }
                    } else {
                        switch (operator) {
                            case "startswith":
                                flquery = " Where lower(" + filterfield + ") LIKE lower('" + value + "%')";
                                break;
                            case "contains":
                                flquery = " Where lower(" + filterfield + ") LIKE lower('%" + value + "%')";
                                break;
                            case "doesnotcontain":
                                flquery = " Where lower(" + filterfield + ") NOT LIKE lower('%" + value + "%')'";
                                break;
                            case "endswith":
                                flquery = " Where lower(" + filterfield + ") LIKE lower('%" + value + "')";
                                break;
                            case "neq":
                                flquery = " Where lower(" + filterfield + ") != lower('" + value + "')";
                                break;
                            case "eq":
                                flquery = " Where lower(" + filterfield + ") = lower('" + value + "')";
                                break;
                            case "aeq":
                                flquery = " AND lower(" + filterfield + ") = lower('" + value + "')";
                                break;
                            case "gte":
                                flquery = " Where " + filterfield + " >= '" + value + "'";
                                break;
                            case "lte":
                                flquery = " Where " + filterfield + " <= '" + value + "'";
                                break;
                            case "nlike":
                                flquery = " Where " + filterfield + " LIKE ('" + value + "%')";
                                break;
                            case "leq":
                                flquery = " Where " + filterfield + " = '" + value + "'";
                                break;
                            case "lj":
                                flquery = " Where " + filterfield + " (+)= '" + value + "'";
                                break;
                            case "rj":
                                flquery = " Where " + filterfield + " =(+) '" + value + "'";
                                break;
                            case "lengthReverse":
                                flquery = " Where length(" + filterfield + ") = '" + value + "'";
                                break;
                            case "lengthGte":
                                flquery = " Where length(" + filterfield + ") >= '" + value + "'";
                                break;
                            case "length":
                                flquery = " Where " + filterfield + " = length('" + value + "')";
                                break;
                            case "ids":
                                flquery = " Where " + filterfield + " in (" + value + ")";
                                break;
                            case "in":
                                /*String[] list = value.substring(1, value.length() - 1).split(",");
                                if(list.length>0){
                                    String ids = "";
                                    for (String st : list) {
                                        ids = ids + "','" + st.substring(1, st.length() - 1);
                                    }
                                    if(ids.length()>2) {
                                        flquery = " Where " + filterfield + " in (" + ids.substring(2, ids.length()) + "')";
                                    }
                                }*/

                                if(value.length() >1){
                                    String[] list = value.substring(1, value.length() - 1).split(",");

                                    if(list.length>0){
                                        String ids = "";
                                        for (String st : list) {
                                            if(st.length()>1){
                                                ids = ids + "','" + st.substring(1, st.length() - 1);
                                            }
                                        }
                                        if(ids.length()>2){
                                            flquery = " Where " + filterfield + " in (" + ids.substring(2, ids.length()) + "')";
                                        }
                                    }
                                }
                                else{
                                    flquery = flquery + " " + logic + " " + filterfield + " in ('" + value + "')";
                                }

                                break;
                            case "isNull":
                                flquery = flquery + " " + logic + " " + filterfield + " is null";
                                break;
                            case "notNull":
                                flquery = flquery + " " + logic + " " + filterfield + " is not null";
                                break;
                        }
                    }
                }
            }
        }
        return flquery;
    }

    @CacheEvict(value = "customers", key = "#id")
    public void evict(long id) {
    }

    public String getAggregate(String request) {
        String field = "";
        String group = "";
        String multiOrde = "";
        String action = "";
        String query = "";
        JSONObject obj = new JSONObject(request);
        JSONArray arr = obj.getJSONArray("aggregate");
        for (int i = 0; i < arr.length(); i++) {
            String str = arr.get(i).toString();
            JSONObject srt = new JSONObject(str);
            if (srt.isNull("field")) {
                field = "";
            } else {
                field = srt.getString("field");
                String replaceString = field.replaceAll("([A-Z]+)", "\\_$1").toLowerCase();
                field = replaceString;

            }
            if (!srt.isNull("aggregate")) {
                action = srt.getString("aggregate");
                if(action.equalsIgnoreCase("sum")){
                    query=query+ "sum("+field+") as "+field+"_1 ,";
                }
                else if(action.equalsIgnoreCase("count")){
                    query=query+ "count("+field+") as "+field+"_1 ,";
                }
            }
        }

        query = query.substring(0, query.length() - 1);


        return query;
    }
}
