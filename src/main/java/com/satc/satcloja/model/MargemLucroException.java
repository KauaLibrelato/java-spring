package com.satc.satcloja.model;

public class MargemLucroException extends Exception{

    public MargemLucroException(){
        super("A margem de lucro deve ser maior ou igual a 20%!");
    }
}
