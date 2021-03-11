package com.usac.olc1.nodos;

import com.usac.olc1.st.SymbolTableManager;
import com.usac.olc1.st.Tree;

public class IdNode extends Node {

    int line;
    int column;

    @Override
    public Object execute(SymbolTableManager table, Tree tree) {
        return null;
    }
   
    public IdNode(int line, int column) {
        super(line, column);
    }


}
