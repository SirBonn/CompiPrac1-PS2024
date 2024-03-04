package com.srbn.Obj;

import java.util.ArrayList;
import java.util.List;

public class Query {

    private int type;
    private List<Column> columns;
    private List<Value> values;
    private List<Condition> conditions;

    private List<Query> queries;

    public Query() {
        this.columns = new ArrayList<>();
        this.values = new ArrayList<>();
        this.conditions = new ArrayList<>();
        this.queries = new ArrayList<>();
    }

//    public Query(int type, List<String> columns, List<Value> values) {
//
//    }


    public void addQuery(Query query){
        queries.add(query);
    }

    public void addValue(Value value){
        values.add(value);
    }

    //getters n setters


    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }



    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }
}
