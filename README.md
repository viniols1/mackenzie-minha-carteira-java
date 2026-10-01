# MinhaCarteira 💰

Sistema de gestão financeira pessoal desenvolvido em **Java** com arquitetura baseada no padrão **DAO (Data Access Object)**, utilizando **JDBC** e persistência de dados com **SQLite**.

---

## 🚀 Tecnologias Utilizadas

* **Java 17+**
* **SQLite** (Base de dados local)
* **SQLite JDBC Driver** (`org.xerial:sqlite-jdbc`)
* **SLF4J Simple** (Gestão de logs)
* **Maven** (Gestão de dependências)

---

## 📂 Estrutura do Projeto

O projeto está organizado em pacotes dentro de `src/main/java/br/com/minhacarteira`:

* **`ConexaoFactory.java`**: Fábrica responsável por estabelecer a conexão com a base de dados SQLite (`carteira.db`).
* **`TransacaoDAO`**: Classe responsável pelas operações de persistência (Criação da tabela, Inserção e Listagem de transações).
* **`Transacao`** (e subclasses **`Receita`** / **`Despesa`**): Classes de modelo que representam as movimentações financeiras.
* **`Sistema`**: Classe principal (`main`) para execução dos testes e demonstração do funcionamento do sistema.

---

## ⚙️ Como Executar o Projeto

1. Certifica-te de que tens o **Java JDK** e o **Maven** instalados no teu computador.
2. Clona ou abre este projeto no teu ambiente de desenvolvimento (por exemplo, **IntelliJ IDEA**).
3. Aguarda o Maven carregar as dependências automaticamente através do ficheiro `pom.xml`.
4. Abre a classe **`Sistema.java`**.
5. Clica no botão de execução (**Run 'Sistema.main()'**) para iniciar a aplicação.

Ao executar, o sistema criará automaticamente o ficheiro de base de dados local (`carteira.db`), efetuará a inserção de registos de exemplo e exibirá a listagem completa na consola.