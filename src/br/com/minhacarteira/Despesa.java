package br.com.minhacarteira;

public class Despesa extends Transacao {

    public Despesa(String descricao, double valor, String data) throws ValorInvalidoException {
        super(descricao, valor, data);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Despesa: " + getDescricao() + " | Valor: R$ -" + getValor() + " | Data: " + getData());
    }
}