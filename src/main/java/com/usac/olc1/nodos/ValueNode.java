package com.usac.olc1.nodos;

import com.usac.olc1.st.SymbolTableManager;
import com.usac.olc1.st.Tree;
import com.usac.olc1.st.Type;

public class ValueNode extends Node{
    Object value;

    public ValueNode(Type type, Object value, int line, int column) {
        super(type, line, column);
        this.value = value;
    }

    @Override
    public Object execute(SymbolTableManager table, Tree tree) {
        System.out.println("ValueNode.execute --> " + this.value.toString());
        return this.value;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
    
    
}
