package com.usac.olc1.st;

enum typesError{
    LEXICO{
        @Override 
        public String printType() {
            return "[Error Lexico] ->";
        }
    },
    SINTACTICO{
        @Override 
        public String printType() {
            return "[Error Sintactico] ->";
        }
    },
    SEMANTICO{
        @Override 
        public String printType() {
            return "[Error - Semantico] ->";
        }
    };
    public abstract String printType();
}

public class TypeError {
    typesError type;

    public TypeError(typesError type) {
        this.type = type;
    }

}
