package com.usac.olc1.st;

import java.util.HashMap;

public class SymbolTable {

    HashMap<String, Symbol> t;
    SymbolTable previousContext;

    public SymbolTable(HashMap<String, Symbol> t) {
        this.t = t;
    }

    public SymbolTable(HashMap<String, Symbol> t, SymbolTable previousContext) {
        this.t = t;
        this.previousContext = previousContext;
    }
    
}
