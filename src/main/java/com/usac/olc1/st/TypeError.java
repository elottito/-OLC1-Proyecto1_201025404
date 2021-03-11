package com.usac.olc1.st;
public class TypeError {

    public enum typesError{
        LEXICO,
        SINTACTICO,
        SEMANTICO;
    }

    public static typesError getType(Object obj) {
        
        if (obj != null) {
            String t = obj.getClass().getSimpleName();
            switch (t) {
                case "LEXICO":
                    return   typesError.LEXICO;
                case "SINTACTICO":
                    return typesError.SINTACTICO;
                case "SEMANTICO":
                    return typesError.SEMANTICO;                    
            }
        }

        return null;
    }

}
