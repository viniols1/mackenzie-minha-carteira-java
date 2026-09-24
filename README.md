# 💰 Sistema Minha Carteira - Mackenzie

Repositório acadêmico desenvolvido para a disciplina de **Programação de Sistemas II** do curso de Tecnologia em Análise e Desenvolvimento de Sistemas da **Universidade Presbiteriana Mackenzie**.

> **⚠️ Status do Projeto: Em Andamento / Desenvolvimento Contínuo**
> Este projeto está em construção e continuará sendo atualizado progressivamente no decorrer do semestre com as próximas etapas da atividade prática.

---

## 🚀 Sobre o Projeto
O **Minha Carteira** é um sistema de gestão financeira pessoal desenvolvido em Java que simula o controle de receitas e despesas. O objetivo da aplicação é aplicar na prática os pilares da Orientação a Objetos (POO), tratamento robusto de erros, manipulação de arquivos e persistência de dados.

## 🛠️ Tecnologias e Conceitos Aplicados (Até o momento)
* **Linguagem:** Java
* **Programação Orientada a Objetos (POO):** Classes abstratas, herança, polimorfismo e interfaces.
* **Tratamento de Exceções:** Criação de exceções customizadas (*checked exceptions* com `ValorInvalidoException`) e blocos `try-catch`.
* **Persistência de Dados & I/O:** Serialização de objetos (`Serializable`) salvos em arquivo binário (`transacoes.bin`) e exportação de relatórios em formato CSV (`extrato.csv`).

## 📚 Etapas Desenvolvidas
* **Aula 1:** Modelagem da estrutura base (Classe abstrata `Transacao`, interface `Tributavel`, classes concretas `Receita` e `Despesa` e polimorfismo na classe `Sistema`).
* **Aula 2:** Implementação de validações de negócio e da exceção personalizada `ValorInvalidoException`.
* **Aula 3:** Implementação da serialização e do gerenciamento de arquivos (`GerenciadorArquivos`) para persistência de dados e geração de extratos.
* **Próximas Aulas:** *Em breve novas funcionalidades.*

---
Desenvolvido por **Vinicius Oliveira** 