package com.srbn.Obj;

import java.util.ArrayList;
import java.util.List;

public class Column {

    private String name;
    private List<Column> columns;

    public Column() {
        this.columns = new ArrayList<>();
    }

    public Column(String name) {
        this.name = name;
    }

    public void addColumn(Column col){
        columns.add(col);
    }

    //gettes n setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
}
