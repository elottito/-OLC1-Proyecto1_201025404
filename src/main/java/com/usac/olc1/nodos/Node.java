package com.usac.olc1.nodos;

import com.usac.olc1.st.SymbolTableManager;
import com.usac.olc1.st.Tree;
import com.usac.olc1.st.Type;

public abstract class Node {
    Type type;
    int line;
    int column;
   
    public Node(Type type, int line, int column) {
        this.type = type;
        this.line = line;
        this.column = column;
    }

    public abstract Object execute(SymbolTableManager table, Tree tree);
    
}
