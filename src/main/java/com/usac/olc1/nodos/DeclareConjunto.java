package com.usac.olc1.nodos;

import com.usac.olc1.st.ExceptionST;
import com.usac.olc1.st.Symbol;
import com.usac.olc1.st.SymbolTableManager;
import com.usac.olc1.st.Tree;
import com.usac.olc1.st.Type;
import com.usac.olc1.st.TypeError;

public class DeclareConjunto extends Node {

    Type type;
    String id;
    Node value;
    int line;
    int column;

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
        this.line = line;
        this.column = column;
    }

    @Override
    public Object execute(SymbolTableManager table, Tree tree) {
        Object result = this.value.execute(table, tree);

        if (result instanceof ExceptionST) {
            return result;
        }

        // Verificar si ya existe en la Tabla de Simbolos
        Symbol var_ = table.getId(id);
        if (var_ == null) {
            // Es una nueva variable --> Agregar a la TS
            table.setId(new Symbol(type, id, result, "conjunto"));
        } else {
            // Error Semantico, Ya Existe la variable
            String strID = var_.identifier;
            String tipoError = TypeError.typesError.SEMANTICO.toString();
            String descripcion = "El Identificador ya existe en la Tabla de Simbolos.<br>Conflicto con el Identificador:  <b>"
                    + strID + "</b>";
            ExceptionST error = new ExceptionST(tipoError, descripcion, line, column);
            tree.exceptions.add(error);
            System.out.println(descripcion);
        }

        // Imprimiendo DeclareConjunto
        Symbol s;
        s = table.getId(id);
        System.out.println("CONJ: -> " + s.identifier + "\t" + result.toString());

        return result;
    }

}
