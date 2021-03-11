package com.usac.olc1.nodos;

import com.usac.olc1.st.SymbolTableManager;
import com.usac.olc1.st.Tree;

public class ListCharNode extends Node {

    Node caracter;
    int line;
    int column;

    @Override
    public Object execute(SymbolTableManager table, Tree tree) {


        return null;
    }

    public ListCharNode(Node caracter, int line, int column) {
        super(line, column);
        this.caracter = caracter;
        System.out.println("Constructor ListChatNode -> " + caracter);
    }

    
}
