package com.usac.olc1.nodos;

import com.usac.olc1.st.SymbolTableManager;
import com.usac.olc1.st.Tree;

public class ValueNode extends Node{
    Object value;
    int line;
    int column;

    public ValueNode(Object value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    @Override
    public Object execute(SymbolTableManager table, Tree tree) {
        System.out.println("Execute ValueNode ->" + value);
        return value;
    }
    
}
