package com.usac.olc1.st;
public class Type {

    types type;

    public enum types{
        CHAR,
        STRING,
        CONJUNTO,
        EXPRESION,
        VOID
    }

    public Type(types type) {
        this.type = type;
    }

    public static types getType(Object obj) {
        
        if (obj != null) {
            String t = obj.getClass().getSimpleName();
            switch (t) {
                case "CHAR":
                    return   types.CHAR;
                case "STRING":
                    return types.STRING;
                case "CONJUNTO":
                    return types.CONJUNTO;
                case "EXPRESION":
                    return types.EXPRESION;
                case "VOID":
                    return types.VOID;
            }
        }

        return null;
    }

}
