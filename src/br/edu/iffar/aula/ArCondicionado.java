package br.edu.iffar.aula;

public class ArCondicionado {

    private boolean ligado;
    public String marca;


    public ArCondicionado (String marca){
        this.marca = marca;
    }

    public void ligar (){
        this.ligado = true;
    }//só pode ser manipulado dentro da classe por ser private

    public void desligar(){
        this.ligado = false;
    }
}
