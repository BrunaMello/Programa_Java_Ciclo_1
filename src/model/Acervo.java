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
public class Acervo {

    /**
     * @return the objeditora
     */
    
    
    private int idAcervo;
    private int idEditora_Acervo;
    private String titulo;
    private String autor;
    private int ano;
    private Double preco;
    private int quantidade;
    private int tipo;
    private Editora objeditora;
    
    
     
    
    public Editora getObjeditora() {
        return objeditora;
    }

    /**
     * @param objeditora the objeditora to set
     */
    public void setObjeditora(Editora objeditora) {
        this.objeditora = objeditora;
    }
    
    
    
    

    /**
     * @return the idAcervo
     */
    public int getIdAcervo() {
        return idAcervo;
    }

    /**
     * @param idAcervo the idAcervo to set
     */
    public void setIdAcervo(int idAcervo) {
        this.idAcervo = idAcervo;
    }

    /**
     * @return the idEditora_Acervo
     */
    public int getIdEditora_Acervo() {
        return idEditora_Acervo;
    }

    /**
     * @param idEditora_Acervo the idEditora_Acervo to set
     */
    public void setIdEditora_Acervo(int idEditora_Acervo) {
        this.idEditora_Acervo = idEditora_Acervo;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the preco
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
    
}
