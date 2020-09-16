/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Acervo;
import model.Editora;

/**
 *
 * @author bruna
 */
public class AcervoDAO {
    
    private Connection conecta;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
       
    public AcervoDAO(){
        this.conecta = new Conexao().conectar();
    }
    
    public void CadastrarLivro(Acervo livro) {
        try {

            String sql = "INSERT INTO acervo(titulo, autor, ano, preco, quantidade, tipo, idEditora_Acervo) VALUES (?,?,?,?,?,?,?);";

            stmt = conecta.prepareStatement(sql);

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno());
            stmt.setDouble(4, livro.getPreco());
            stmt.setInt(5, livro.getQuantidade());
            stmt.setInt(6, livro.getTipo());
            stmt.setInt(7, livro.getObjeditora().getIdEditora());

            stmt.execute();

            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e);
        }   
    }
    
    public void AtualizarLivro(Acervo l){
        try {
            String sql = "UPDATE acervo SET titulo=?, autor=?, ano=?, preco=?, "
                    + "quantidade=?, tipo=?, idEditora_Acervo=? "
                    + "WHERE idAcervo=?";
            
            stmt = conecta.prepareStatement(sql);

            stmt.setString(1, l.getTitulo());
            stmt.setString(2, l.getAutor());
            stmt.setInt(3, l.getAno());
            stmt.setDouble(4, l.getPreco());
            stmt.setInt(5, l.getQuantidade());
            stmt.setInt(6, l.getTipo());
            stmt.setInt(7, l.getObjeditora().getIdEditora()); 
            stmt.setInt(8, l.getIdAcervo());
            
            stmt.execute();

            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Alteração feita com sucesso!");
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e);
        } 
    } 
    
    public List<Acervo> ListarLivro() {
        try {
            // vetor para armazenar as editoras 
            List<Acervo> listalivro = new ArrayList<Acervo>();

            //comando
            String sql = "SELECT acervo.idAcervo, acervo.titulo, acervo.autor, acervo.ano, acervo.preco, "
                    + "acervo.quantidade, acervo.tipo, "
                    + "editora.idEditora, editora.nomeEditora "
                    + "FROM acervo "
                    + "INNER JOIN editora "
                    + "ON acervo.idEditora_Acervo = editora.idEditora;";

            //execucao
            stmt = conecta.prepareStatement(sql);

            //guardar reultado
            rs = stmt.executeQuery();

            //guardar todos os registros na lista 
            while (rs.next()) {

                //registros da tabela acervo
                Acervo livro = new Acervo();

                livro.setIdAcervo(rs.getInt("idAcervo"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setAno(rs.getInt("ano"));
                livro.setPreco(rs.getDouble("preco"));
                livro.setQuantidade(rs.getInt("quantidade"));
                livro.setTipo(rs.getInt("tipo"));
                
                

                //registros da tabela editora
                Editora editora = new Editora();
                editora.setNomeEditora(rs.getString("nomeEditora"));
                editora.setIdEditora(rs.getInt("idEditora"));
                

                //enviar dados tb editora para tb acervo
                livro.setObjeditora(editora);

                listalivro.add(livro);
            }

            return listalivro;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } // atualizado
    
    public List<Acervo> PesquisarLivroTitulo(String titulo){
        try {
            // vetor para armazenar as editoras 
            List<Acervo> listalivro = new ArrayList<Acervo>();

            //comando
            String sql = "SELECT acervo.idAcervo, acervo.titulo, acervo.autor, acervo.ano, acervo.preco, "
                    + "acervo.quantidade, acervo.tipo, "
                    + "editora.idEditora, editora.nomeEditora "
                    + "FROM acervo "
                    + "INNER JOIN editora "
                    + "ON acervo.idEditora_Acervo = editora.idEditora "
                    + "WHERE titulo LIKE ?;";
            
            //execucao
            stmt = conecta.prepareStatement(sql);
            stmt.setString(1, "%" + titulo + "%");

            //guardar reultado
            rs = stmt.executeQuery();

            //guardar todos os registros na lista 
            while (rs.next()) {

                //registros da tabela acervo
                Acervo livro = new Acervo();

                livro.setIdAcervo(rs.getInt("idAcervo"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setAno(rs.getInt("ano"));
                livro.setPreco(rs.getDouble("preco"));
                livro.setQuantidade(rs.getInt("quantidade"));
                livro.setTipo(rs.getInt("tipo"));
                
                

                //registros da tabela editora
                Editora editora = new Editora();
                editora.setNomeEditora(rs.getString("nomeEditora"));
                editora.setIdEditora(rs.getInt("idEditora"));
                

                //enviar dados tb editora para tb acervo
                livro.setObjeditora(editora);

                listalivro.add(livro);
            }

            return listalivro;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } // atualizado
    
    public void ExcluirLivro(Acervo l){
        try {
            
            String sql = "DELETE FROM acervo WHERE idAcervo=?";
            
            stmt = conecta.prepareStatement(sql);

            stmt.setInt(1, l.getIdAcervo());

            stmt.execute();
            
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão: " + erro); 
        } 
    } 
}
