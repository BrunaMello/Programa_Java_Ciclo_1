/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Acervo;


/**
 *
 * @author bruna
 */
public class TabelaLivroTableModel extends AbstractTableModel {
    
    private String colunas[] = {"idlivro", "titulo", "autor", "ano", "preco", "quantidade", "tipo", "ideditora_livro"};
    private ArrayList<Acervo> livros;
    private final int COLUNA_IDLIVRO = 0;
    private final int COLUNA_TITULO = 1;
    private final int COLUNA_AUTOR = 2;
    private final int COLUNA_ANO = 3;
    private final int COLUNA_PRECO = 4;
    private final int COLUNA_QUANTIDADE = 5;
    private final int COLUNA_TIPO = 6;
    private final int COLUNA_IDEDITORA = 7;
    
    public TabelaLivroTableModel(ArrayList<Acervo> livros) {
        this.livros = livros;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }

    @Override
    public int getRowCount() {
         return livros.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int indice){
        return colunas[indice];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case COLUNA_IDLIVRO:
                return Integer.class;
            case COLUNA_TITULO:
                return String.class;
            case COLUNA_AUTOR:
                return String.class;
            case COLUNA_ANO:
                return Integer.class;
            case COLUNA_PRECO:
                return Double.class; 
            case COLUNA_QUANTIDADE:
                return Integer.class;
            case COLUNA_TIPO:
                return Integer.class;
            case COLUNA_IDEDITORA:
                return String.class;
            default:
                return String.class;
        }
    }
        

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Acervo livro = this.livros.get(rowIndex);
        
        switch(columnIndex){
            case COLUNA_IDLIVRO:
                return livro.getIdAcervo();
            case COLUNA_TITULO:
                return livro.getTitulo();
            case COLUNA_AUTOR:
                return livro.getAutor();
            case COLUNA_ANO:
                return livro.getAno();
            case COLUNA_PRECO:
                return livro.getPreco();
            case COLUNA_QUANTIDADE:
                return livro.getQuantidade();
            case COLUNA_TIPO:
                return livro.getTipo();
            case COLUNA_IDEDITORA:
                return livro.getIdEditora_Acervo();
        }
        
        return null;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Acervo livro = this.livros.get(rowIndex);
        
        switch(columnIndex){
            case COLUNA_IDLIVRO:
                livro.setIdAcervo((int) aValue);
                break;
            case COLUNA_TITULO:
                livro.setTitulo(String.valueOf(aValue));
                break;
            case COLUNA_AUTOR:
                livro.setAutor(String.valueOf(aValue));
                break;
            case COLUNA_ANO:
                livro.setAno((int) aValue);
                break;
            case COLUNA_PRECO:
                livro.setPreco((double) aValue);
                break;
            case COLUNA_QUANTIDADE:
                livro.setQuantidade((int) aValue);
                break;
            case COLUNA_TIPO:
                livro.setTipo((int) aValue);
                break;
            case COLUNA_IDEDITORA:
                livro.setIdEditora_Acervo((int) aValue);
                break;
        }
        fireTableDataChanged();
    }    
}
