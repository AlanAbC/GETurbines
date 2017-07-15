package com.claresti.geturbines;

import java.util.ArrayList;

/**
 * Created by alana on 15/07/2017.
 */

public class ArrayVariables {

    private static ArrayList<Variables>var= new ArrayList<Variables>();

    public static void setArrayVariables(ArrayList<Variables> variables){
        var=variables;
    }
    public static ArrayList<Variables> getArrayVariables(){
        return var;
    }

}
