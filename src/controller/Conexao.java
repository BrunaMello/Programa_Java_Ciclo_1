/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bruna
 */
public class Conexao {

    private static final String DATABASE = "Acervo_Editora";
    private static final String HOST = "localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "011991";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://" + HOST + "/" + DATABASE + "?useTimezone=true&serverTimezone=UTC";

    public static Connection conectar() {
        try {
            Class.forName(DRIVER);
            return (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public static void desconectar(Connection con) {
        try {
            if (con != null) {
                con.close();
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
