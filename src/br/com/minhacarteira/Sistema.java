package br.com.minhacarteira;

import java.util.List;

public class Sistema {
    public static void main(String[] args) {
        List<Transacao> transacoes = GerenciadorArquivos.carregarDados();
        System.out.println("Total de transações carregadas: " + transacoes.size());

        try {
            transacoes.add(new Despesa("Internet", 100.00, "20/08/2026"));
            System.out.println("Nova transação adicionada com sucesso!");
        } catch (ValorInvalidoException e) {
            System.out.println("Erro ao adicionar transação: " + e.getMessage());
        }

        GerenciadorArquivos.salvarDados(transacoes);

        GerenciadorArquivos.gerarExtrato(transacoes);
        System.out.println("Extrato gerado com sucesso em 'extrato.csv'.");

        System.out.println("\n--- Relatório Atualizado de Transações ---");
        for (Transacao t : transacoes) {
            t.exibirDetalhes();
            if (t instanceof Tributavel) {
                double imposto = ((Tributavel) t).calcularImposto();
                System.out.println("   -> Imposto referente a esta transação: R$ " + imposto);
            }
            System.out.println();
        }
    }
}