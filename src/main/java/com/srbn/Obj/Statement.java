package com.srbn.Obj;

import java.util.ArrayList;
import java.util.List;

public class Statement {

    private String column;
    private String sign;
    private String value;

    private List<Statement> conditions;

    public Statement() {
        this.conditions = new ArrayList<>();
    }

    public Statement(String column, String sign, String value) {
        this.column = column;
        this.sign = sign;
        this.value = value;
    }

    public addCondition(Statement condition){
        this.conditions.add(condition);
    }

    //getters n setters
    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Statement> getConditions() {
        return conditions;
    }

    public void setConditions(List<Statement> conditions) {
        this.conditions = conditions;
    }
}
