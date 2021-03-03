package com.usac.olc1.st;

public class Symbol {
    
    String id;
    public Object value;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Symbol(String id, Object value) {
        this.id = id;
        this.value = value;
    }

}
