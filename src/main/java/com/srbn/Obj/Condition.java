package com.srbn.Obj;

public class Condition {

    private String column;
    private Object condition;

    public Condition(String column, Object condition) {
        this.column = column;
        this.condition = condition;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public Object getCondition() {
        return condition;
    }

    public void setCondition(Object condition) {
        this.condition = condition;
    }
}
