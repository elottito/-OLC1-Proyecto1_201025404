package com.usac.olc1.nodos;

import java.util.ArrayList;

public class ListCharNode extends Node {

    Node caracter;

    @Override
    public Object execute() {

        String r1 = caracter.execute().toString();
        System.out.println("Execute ListChatNode -> " + r1);

        ArrayList<String> result = new ArrayList<String>();
        result.add(r1);
        return r1;
    }

    public ListCharNode(Node caracter) {
        System.out.println("Constructor ListChatNode -> " + caracter);
        this.caracter = caracter;
    }

    
}
