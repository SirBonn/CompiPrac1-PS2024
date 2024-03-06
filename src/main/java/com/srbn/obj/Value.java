package com.srbn.obj;

import java.util.ArrayList;
import java.util.List;

public class Value {

    private int valueInt;
    private String valueStr;

    private List<Value> values;

    public Value(int valueInt) {
        this.valueInt = valueInt;
    }

    public Value() {
        this.values = new ArrayList<>();
    }

    public Value(String valueStr) {
        this.valueStr = valueStr;
    }

    public void addValue(Value value) {
        this.values.add(value);
    }

    //getters n setters
    public int getValueInt() {
        return valueInt;
    }

    public void setValueInt(int valueInt) {
        this.valueInt = valueInt;
    }

    public String getValueStr() {
        return valueStr;
    }

    public void setValueStr(String valueStr) {
        this.valueStr = valueStr;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }
}
