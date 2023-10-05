/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.model.enums;

/**
 *
 * @author alice
 */
public enum StatusEvento {
    
    CONFIRMADO(1, "Confirmado"),
    CANCELADO(2, "Cancelado");
    
    private int cod;
    private String descricao;

    StatusEvento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public static StatusEvento toEnum(Integer cod){
        if (cod==null){
            return null;
        }
        for (StatusEvento x: StatusEvento.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido "+cod);
    }
    public static StatusEvento toEnum(String cod){
        if (cod==null){
            return null;
        }
        for (StatusEvento x: StatusEvento.values()){
            if(cod.equals(x.getDescricao())){
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido "+cod);
    }
}
