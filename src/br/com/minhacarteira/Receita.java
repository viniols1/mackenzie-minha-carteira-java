package br.com.minhacarteira;

public class Receita extends Transacao implements Tributavel {

    public Receita(String descricao, double valor, String data) throws ValorInvalidoException {
        super(descricao, valor, data);
    }

    @Override
    public double calcularImposto() {
        return getValor() * 0.10;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Receita: " + getDescricao() + " | Valor: R$ " + getValor() + " | Data: " + getData() + " | Imposto (10%): R$ " + calcularImposto());
    }
}