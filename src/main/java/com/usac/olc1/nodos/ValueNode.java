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
        return this.value;
    }
    
    
}
