package com.usac.olc1.nodos;

import java.util.ArrayList;
import java.util.Stack;

import com.usac.olc1.st.SymbolTableManager;
import com.usac.olc1.st.Tree;
public class ListCharNode extends Node {

    Stack<Node> pila;

    @Override
    public Object execute(SymbolTableManager table, Tree tree) {
        ArrayList<String> result = new ArrayList<String>();
        
        System.out.println("----- Pila Caracteres ------");
        for(int i=0; i<pila.size(); i++){
            Node arg = pila.get(i);
            arg.execute(table, tree);
        }
        System.out.println("----- Fin Pila  ------");
        return result;
    }

    public ListCharNode(Stack<Node> pila, int line, int column) {
        super(null, line, column);
        this.pila = pila;
    }

    
}
