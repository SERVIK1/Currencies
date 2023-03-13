package ru.raspgleb.currenciesoftheworld;

import java.io.Serializable;

public class Currency implements Serializable {

    private String name; // Название валюты
    private int image; // Изображение флага

    public Currency(){
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getImage() {return image;}
    public void setImage(int image) {this.image = image;}
}
