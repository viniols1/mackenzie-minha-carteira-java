package br.com.minhacarteira;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    private static final String URL = "jdbc:sqlite:carteira.db";

    public static Connection conectar() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver do SQLite não encontrado: " + e.getMessage());
        }
        return DriverManager.getConnection(URL);
    }
}