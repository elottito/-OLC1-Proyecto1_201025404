package com.usac.olc1.nodos;

import com.usac.olc1.st.SymbolTableManager;
import com.usac.olc1.st.Tree;

public abstract class Node {
    int line;
    int column;
   
    public Node(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public abstract Object execute(SymbolTableManager table, Tree tree);
    
}
