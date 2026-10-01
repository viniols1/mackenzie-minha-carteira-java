package br.com.minhacarteira;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {

    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS transacoes (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "descricao TEXT NOT NULL, " +
                "valor REAL NOT NULL, " +
                "data TEXT NOT NULL, " +
                "tipo TEXT NOT NULL)";
        try (Connection conn = ConexaoFactory.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public void salvar(Transacao t) {
        String sql = "INSERT INTO transacoes (descricao, valor, data, tipo) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoFactory.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, t.getDescricao());
            pstmt.setDouble(2, t.getValor());
            pstmt.setString(3, t.getData());

            if (t instanceof Receita) {
                pstmt.setString(4, "RECEITA");
            } else if (t instanceof Despesa) {
                pstmt.setString(4, "DESPESA");
            }

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar transação: " + e.getMessage());
        }
    }

    public List<Transacao> listar() throws ValorInvalidoException {
        List<Transacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM transacoes";
        try (Connection conn = ConexaoFactory.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                double valor = rs.getDouble("valor");
                String data = rs.getString("data");
                String tipo = rs.getString("tipo");

                if ("RECEITA".equals(tipo)) {
                    Receita r = new Receita(descricao, valor, data);
                    lista.add(r);
                } else if ("DESPESA".equals(tipo)) {
                    Despesa d = new Despesa(descricao, valor, data);
                    lista.add(d);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar transações: " + e.getMessage());
        }
        return lista;
    }
}