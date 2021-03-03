package com.usac.olc1.nodos;

import java.util.ArrayList;

import com.usac.olc1.st.SymbolTableManager;

public class IdNode extends Node {
    
    String id;
    int fila;
    int col;

   
    public IdNode(String id) {
        this.id = id;
    }

    public IdNode(String id, int col) {
        this.id = id;
        this.col = col;
    }
    
    public IdNode(String id, int col, int fila) {
        this.id = id;
        this.fila = fila;
        this.col = col;
    }

    @Override
    public Object execute() {
        if (col != 0) {
            ArrayList<Object> obj1 = new ArrayList<Object>();
            obj1 = (ArrayList) SymbolTableManager.getid(id).value;
            return obj1.get(col - 1);
        } else {
            if (SymbolTableManager.getid(id) == null) {
                return id;
            } else {
                return SymbolTableManager.getid(id).value;
            }
        }
    }
}
