package com.company;


import java.io.Serializable;

public class Savedata implements Serializable {
    String  name;
    String boothNumber;
    public Savedata(String name, String boothNumber){

        this.name = name;
        this.boothNumber=boothNumber;
    }
    @Override
    public String toString(){
        return "name"+"="+name+" "+"BoothNumber"+"="+boothNumber;
    }
}
