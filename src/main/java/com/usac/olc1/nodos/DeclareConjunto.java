package com.usac.olc1.nodos;

import com.usac.olc1.st.ExceptionST;
import com.usac.olc1.st.SymbolTableManager;
import com.usac.olc1.st.Tree;
import com.usac.olc1.st.Type;

public class DeclareConjunto extends Node {

    Type type;
    String id;
    Node value;

    /**
     * Constructor de DeclareConjunto
     * 
     * @param type   CONJUNTO
     * @param id     nombre
     * @param value  valor
     * @param line   fila
     * @param column columna
     */
    public DeclareConjunto(Type type, String id, Node value, int line, int column) {
        super(type, line, column);
        this.type = type;
        this.id = id;
        this.value = value;
        //String s = "Constructor DeclareConjunto ->\n" + "Tipo [" + type + "] Id [" + id + "] Value [" + value + "]";
        //System.out.println(s);
    }

    @Override
    public Object execute(SymbolTableManager table, Tree tree) {
        Object result = this.value.execute(table, tree);

        if (result instanceof ExceptionST) {
            return result;
        }
        return null;
    }

}
