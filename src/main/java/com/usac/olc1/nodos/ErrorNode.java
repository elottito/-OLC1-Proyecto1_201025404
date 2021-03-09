package com.usac.olc1.nodos;

import com.usac.olc1.st.ExceptionST;
import com.usac.olc1.st.Type;

public class ErrorNode extends Node{
    
    ExceptionST err;
    Type types;

    
    public ErrorNode(ExceptionST err, int fila, int columna) {
        //super( new Type(types.type.VOID), fila, columna);
        this.err = err;
    }

    @Override
    public Object execute() {
        return null;
    }
    
}
