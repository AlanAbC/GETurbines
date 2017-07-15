package com.claresti.geturbines;

import java.util.ArrayList;

public class ConectorOutputs {

    private static ArrayList<Outputs> out = new ArrayList<Outputs>();

    public static ArrayList<Outputs> getOuts(){
        return out;
    }

    public static void setOut(ArrayList<Outputs> outIn){
        out = outIn;
    }

}
