![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)

# Sistema de Gerenciamento Escolar (JPA/Hibernate)

Este é um sistema de console desenvolvido em Java para gerenciar o cadastro de turmas e alunos, utilizando o paradigma de mapeamento objeto-relacional (ORM) com **JPA** e **Hibernate**. O projeto demonstra a implementação de um CRUD completo com relacionamentos `@OneToMany` e `@ManyToOne`.

## 🚀 Novidades da Versão 2.0

Recentemente, o sistema passou por uma refatoração importante na camada de modelo e persistência:
* **Migração de Relacionamento:** O vínculo entre Aluno e Curso foi evoluído de `@ManyToOne` para `@ManyToMany`.
* **Flexibilidade de Matrícula:** Agora, um aluno pode estar vinculado a múltiplos cursos simultaneamente, refletindo melhor a realidade acadêmica.
* **Persistência Avançada:** Implementação de `@JoinTable` para gerenciar a tabela intermediária de associações no banco de dados.
* **Uso de Singleton:** Refinamento do `EntityManagerFactorySingleton` para garantir uma única instância de conexão por aplicação.

## 🚀 Tecnologias Utilizadas

* **Java 21**: Utilizando recursos modernos da linguagem.
* **JPA (Jakarta Persistence)**: Interface padrão para persistência de dados.
* **Hibernate 6.4.4**: Implementação do provedor de persistência.
* **MySQL 8.3.0**: Banco de dados relacional.
* **Maven**: Gerenciamento de dependências e build.

## 🏗️ Arquitetura do Projeto

O projeto segue uma estrutura organizada para separar responsabilidades:

* **`model`**: Contém as entidades JPA (`Student` e `Course`) que representam as tabelas no banco de dados.
* **`service`**: Camada de lógica de negócio (CRUD).
* **`utils`**: Implementação do padrão **Singleton** para gerenciar o `EntityManagerFactory`, garantindo o uso eficiente de recursos.
* **`Main`**: Interface de linha de comando (CLI) para interação com o usuário.

## 📋 Funcionalidades

O sistema permite realizar as seguintes operações:

1. **Gestão de Turmas**:
* Cadastrar nova turma (Nome e Período).
* Listar todas as turmas cadastradas.
* Atualizar dados de uma turma existente.
* Excluir turmas por ID.


2. **Gestão de Alunos**:
* Matricular aluno vinculado a uma turma existente.
* Listar alunos (exibindo detalhes da turma vinculada).
* Atualizar informações cadastrais do aluno.
* Remover aluno do sistema.



## ⚙️ Configuração e Instalação

### 1. Pré-requisitos

* JDK 21 instalado.
* MySQL Server em execução.
* Maven configurado.

### 2. Banco de Dados

Crie o banco de dados no seu MySQL:

```sql
CREATE DATABASE db_sistema_escolar_jpa;

```

### 3. Ajuste de Credenciais

Acesse o arquivo `src/main/resources/META-INF/persistence.xml` e altere as propriedades de conexão com seu usuário e senha:

```xml
<property name="jakarta.persistence.jdbc.user" value="SEU_USUARIO" />
<property name="jakarta.persistence.jdbc.password" value="SUA_SENHA" />

```

## Demonstração do Projeto

![Sistema Escolar com JDBC](https://github.com/user-attachments/assets/7b20150e-f183-458d-b06d-17a8350f9785)

---
:octocat:   SOBRE A DESENVOLVEDORA  

![Isabela Marques](https://github.com/user-attachments/assets/76a8e0d4-8a08-45cd-9e9b-18f70cc0122c)


**🎓Isabela Cavalcante Marques** *Desenvolvedora Java Backend*

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/isabela-cavalcante-marques-9a91863a8)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Isabelaestuda)
[![Gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:devisamarques@gmail.com)

