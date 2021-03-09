package com.usac.olc1.st;

import java.util.HashMap;
import java.util.Stack;

public class SymbolTableManager {
    static Stack<SymbolTable> ts;
    static SymbolTable currentContext;

    public static void Init() {
        ts = new Stack<SymbolTable>();
        ts.push(new SymbolTable(new HashMap<String, Symbol>()));
        currentContext = ts.peek();
    }

    // Abrir un nuevo contexto
    public static void openContext() {
        ts.push(new SymbolTable(new HashMap<String, Symbol>(), currentContext));
        currentContext = ts.peek();
    }

    // Cerrar contexto
    public static void closeContext() {
        ts.pop();
        currentContext = ts.peek();
    }

    // Crear
    public static void setid(Symbol s) {
        currentContext.t.put(s.id, s);
    }

    /**
     *
     * @method getId Obtiene una variable dentro de la tabla de simbolos
     * @param id Nombre de la variable a obtener
     */
    public static Symbol getId(String id) {
        if (currentContext.t.containsKey(id)) {
            return currentContext.t.get(id);
        } else {
            SymbolTable prev = currentContext.previousContext;
            while (prev != null) {
                if (prev.t.containsKey(id)) {
                    return prev.t.get(id);
                } else {
                    prev = prev.previousContext;
                }
            }
        return null;
        }
    }
}
