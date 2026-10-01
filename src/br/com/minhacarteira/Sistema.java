package br.com.minhacarteira;

import java.util.List;

public class Sistema {
    public static void main(String[] args) throws ValorInvalidoException {
        TransacaoDAO dao = new TransacaoDAO();

        dao.criarTabela();

        Receita receitaExemplo = new Receita("Salario", 5000.0, "01/10/2026");
        Despesa despesaExemplo = new Despesa("Aluguel", 1500.0, "05/10/2026");

        dao.salvar(receitaExemplo);
        dao.salvar(despesaExemplo);

        List<Transacao> transacoes = dao.listar();

        System.out.println("=== LISTA DE TRANSAÇÕES DO BANCO DE DADOS ===");
        for (Transacao t : transacoes) {
            t.exibirDetalhes();
            System.out.println("-------------------");
        }
    }
}