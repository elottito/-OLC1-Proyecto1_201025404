package com.usac.olc1.st;

import java.util.ArrayList;

import com.usac.olc1.nodos.Node;

public class Tree {

    public ArrayList<Node> instructions;
    public ArrayList<ExceptionST> exceptions;
    public ArrayList<String> console;
    public ArrayList<Symbol> pila;
    

    public Tree(ArrayList<Node> instructions) {
        this.instructions = instructions;
        this.exceptions = new ArrayList<ExceptionST>();
        this.console = new ArrayList<String>();
        this.pila = new ArrayList<Symbol>();
    }

    
    
    
}
