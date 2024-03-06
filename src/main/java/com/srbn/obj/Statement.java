package com.srbn.obj;

import java.util.ArrayList;
import java.util.List;

public class Statement {

    private String column;
    private String sign;
    private String value;

    private List<Statement> statements;

    public Statement() {
        this.statements = new ArrayList<>();
    }

    public Statement(String column, String sign, String value) {
        this.column = column;
        this.sign = sign;
        this.value = value;
    }

    public void addStatement(Statement statement){
        this.statements.add(statement);
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

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }
}
