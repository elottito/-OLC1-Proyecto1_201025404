package com.usac.olc1.nodos;

import java.util.ArrayList;

import com.usac.olc1.st.SymbolTableManager;
import com.usac.olc1.st.Tree;
public class ListCharNode extends Node {

    ArrayList<Node> lista;
    ValueNode valuenode;

    @Override
    public Object execute(SymbolTableManager table, Tree tree) {
        ArrayList<String> result = new ArrayList<String>();
        
        //Recorriendo la Lista de Caracteres        
        for(int i=0; i<lista.size(); i++){
            Node nodo = lista.get(i);
            result.add((String) nodo.execute(table, tree)); //Execute
        }
        return result;
    }

    public ListCharNode(ArrayList<Node> lista, int line, int column) {
        super(null, line, column);
        this.lista = lista;
    }

    
}
