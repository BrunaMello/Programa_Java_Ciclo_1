/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author bruna
 */
public class Editora {
    
    private int idEditora;
    private String nomeEditora;

    
    /**
     * @return the idEditora
     */
    public int getIdEditora() {
        return idEditora;
    }

    /**
     * @param idEditora the idEditora to set
     */
    public void setIdEditora(int idEditora) {
        this.idEditora = idEditora;
    }

    /**
     * @return the nomeEditora
     */
    public String getNomeEditora() {
        return nomeEditora;
    }

    /**
     * @param nomeEditora the nomeEditora to set
     */
    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }
    
    @Override 
    public String toString(){
        return this.nomeEditora;
    }
    
}
    
    
    
    