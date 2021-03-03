package com.usac.olc1.nodos;

public class ValueNode extends Node{
    Object value;

    public ValueNode(Object value) {
        this.value = value;
        //System.out.println("Constructor ValueNode ->" + value);
    }

    @Override
    public Object execute() {
        System.out.println("Execute ValueNode ->" + value);
        return value;
    }
    
}
