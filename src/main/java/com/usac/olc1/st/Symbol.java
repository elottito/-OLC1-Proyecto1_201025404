package com.usac.olc1.st;

public class Symbol {
    
    public Type type;
    public String identifier;
    public Object value;
    public String ambito;


    public Symbol(Type type, String identifier, Object value, String ambito) {
        this.type = type;
        this.identifier = identifier;
        this.value = value;
        this.ambito = ambito;
    }

}
