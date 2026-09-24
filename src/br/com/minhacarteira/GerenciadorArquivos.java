package br.com.minhacarteira;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorArquivos {

    private static final String NOME_ARQUIVO = "transacoes.bin";
    private static final String NOME_EXTRATO = "extrato.csv";

    public static void salvarDados(List<Transacao> transacoes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO))) {
            oos.writeObject(transacoes);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Transacao> carregarDados() {
        File arquivo = new File(NOME_ARQUIVO);
        if (!arquivo.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOME_ARQUIVO))) {
            return (List<Transacao>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void gerarExtrato(List<Transacao> transacoes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_EXTRATO))) {
            for (Transacao t : transacoes) {
                String linha = t.getDescricao() + "; " + t.getValor() + "; " + t.getData();
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao gerar o extrato: " + e.getMessage());
        }
    }
}