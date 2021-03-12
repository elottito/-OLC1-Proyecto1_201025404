package com.usac.olc1.nodos;

import com.usac.olc1.st.ExceptionST;
import com.usac.olc1.st.Symbol;
import com.usac.olc1.st.SymbolTableManager;
import com.usac.olc1.st.Tree;
import com.usac.olc1.st.TypeError;

public class IdNode extends Node {

    String id;
    int line;
    int column;

    @Override
    public Object execute(SymbolTableManager table, Tree tree) {
        Symbol var;
        var = table.getId(this.id);
        
        if(var ==null){
            String description = "No se ha encontrado la variable declarada: <b>" + this.id + "</b>";
            String tipoError = TypeError.typesError.SEMANTICO.toString();
            ExceptionST error = new ExceptionST(tipoError, description, line, column);
            tree.exceptions.add(error);
            return error;
        }

        this.type = var.type;
        return var.value;
    }

    public IdNode(String id, int line, int column) {
        super(null, line, column);
        this.id = id;
    }

}
