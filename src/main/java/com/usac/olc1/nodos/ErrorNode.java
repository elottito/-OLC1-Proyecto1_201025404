package com.usac.olc1.nodos;

import com.usac.olc1.st.ExceptionST;
import com.usac.olc1.st.SymbolTableManager;
import com.usac.olc1.st.Tree;

public class ErrorNode extends Node{
    
    ExceptionST err;

    int line;
    int column;

    public ErrorNode(ExceptionST err, int line, int column) {
        super(line,column);
        this.err = err;
    }

    @Override
    public Object execute(SymbolTableManager table, Tree tree) {
        tree.exceptions.add(err);
        return null;
    }
    
}
