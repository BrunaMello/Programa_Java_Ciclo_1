/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Editora;

/**
 *
 * @author bruna
 */
public class EditoraDAO {

    private Connection conecta;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public EditoraDAO() {
        this.conecta = new Conexao().conectar();
    }

    public int CadastrarEditora(Editora ed) {
        try {
            
            String sql = "INSERT INTO editora(nome) VALUES (?);";
            
            PreparedStatement cmd = conecta.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            cmd.setString(1, ed.getNomeEditora());
            
            
            if (cmd.executeUpdate() > 0) {
                ResultSet rs = cmd.getGeneratedKeys();
                return (rs.next()) ? rs.getInt(1): -1;
            } else {
                return -1;
            }
            
        } catch (Exception erro) {
            System.out.println("Erro: " + erro.getMessage());
            
            return -1;
            
        } finally {
            
            Conexao.desconectar(conecta);
        } 
    } //atualizado

    public List<Editora> ListarEditora() {
        try {

            String sql = "SELECT idEditora, nomeEditora FROM editora;";

            PreparedStatement stmt = conecta.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            
            List<Editora> listaeditoras = new ArrayList<Editora>();

            while (rs.next()) {
                Editora ed = new Editora();
                ed.setIdEditora(rs.getInt("idEditora"));
                ed.setNomeEditora(rs.getString("nomeEditora"));

                listaeditoras.add(ed);
            }
            return listaeditoras;
            
        } catch (Exception erro) {
            System.out.println("Erro: " + erro.getMessage());
            
            return null;
        }finally {
            Conexao.desconectar(conecta);
        }
    }
}
