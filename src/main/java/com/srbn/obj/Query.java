package com.srbn.obj;

import java.util.ArrayList;
import java.util.List;
import com.srbn.utils.CSVmagnament.CSVManager;

public class Query {

    private int type;
    private String path;
    private List<Column> columns;
    private List<Value> values;
    private List<Statement> assignations;

    private List<Statement> statements;

    private List<Query> queries;

    public Query() {
        this.columns = new ArrayList<>();
        this.values = new ArrayList<>();
        this.statements = new ArrayList<>();
        this.queries = new ArrayList<>();
    }


    public void executeQuery() {

        switch (type) {
            case QueryType.INSERTAR:
                CSVManager.createCSVFile(path, columns, values);
                break;
            case 2:
                CSVManager.readCSVFile(path);
                break;
            case 3:
                CSVManager.updateCSVFile(path, assignations, statements);
                break;
            case 4:
                CSVManager.deleteCSVFile(path, statements);
                break;
            case 5:
                CSVManager.createCSVFile(path, columns, values);
                break;
            case 6:
                CSVManager.readCSVFile(path);
                break;
            case 7:
                CSVManager.updateCSVFile(path, assignations, statements);
                break;
            case 8:
                CSVManager.deleteCSVFile(path, statements);
                break;
        }

    }
    public void addQuery(Query query) {
        queries.add(query);
    }

    public void addValue(Value value) {
        values.add(value);
    }

    //getters n setters
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

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

    public List<Statement> getAssignations() {
        return assignations;
    }

    public void setAssignations(List<Statement> assignations) {
        this.assignations = assignations;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    
}
