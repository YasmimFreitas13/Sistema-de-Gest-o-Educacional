# 🎓 Sistema de Gestão Educacional (EduConnect)

Repositório desenvolvido para a entrega da atividade **Imersão** da disciplina de Programação Orientada a Objetos (POO). O projeto consiste em um **Sistema de Gestão Educacional (SGE)** modularizado em camadas, aplicando os principais conceitos de POO em Java.

---

## 🎯 Objetivo do Projeto
Desenvolver uma aplicação orientada a objetos robusta e segura para a instituição fictícia **EduConnect**, automatizando o controle acadêmico, o gerenciamento de usuários (alunos, professores e administradores), a criação de turmas, o controle restrito de avaliações e a geração automatizada de relatórios estatísticos.

---

## 🏛️ Arquitetura em Camadas
O projeto está organizado em pacotes para garantir a separação de responsabilidades:
* **`model`**: Contém as classes de entidades do domínio, classes abstratas (`Usuario`), interfaces (`Autenticável`) e subclasses (`Aluno`, `Professor`, `Administrador`, `Curso`, `CursoPresencial`, `CursoEAD`, `Turma`, `Avaliacao`).
* **`repository`**: Gerencia o armazenamento temporário em memória utilizando listas estáticas (`List`).
* **`service`**: Concentra as regras de negócio do sistema (cadastros, validações e autenticação).
* **`ui`**: Contém a classe principal (`Main`) com o menu interativo via console para interação do usuário.

---

## 🛠️ Conceitos de POO Aplicados
* **Encapsulamento**: Atributos privados e validação estrita (ex: notas de avaliações limitadas estritamente entre 0 e 10).
* **Herança**: Reutilização de código através de classes base (`Usuario` herdada por `Aluno`, `Professor` e `Administrador`; `Curso` herdada por `CursoPresencial` e `CursoEAD`).
* **Polimorfismo**: Sobrescrita de métodos (`@Override`) como `detalharCurso()` e `gerarRelatorio()`, permitindo execução genérica em laços de repetição (`for`).
* **Interfaces e Classes Abstratas**: Contrato de segurança obrigatório com a interface `Autenticável` e estruturação de modelos genéricos via classe abstrata `Usuario`.

---

## 🚀 Como Executar o Projeto

1. Certifique-se de ter o **Java Development Kit (JDK)** instalado na sua máquina.
2. Clone este repositório ou abra a pasta no seu editor (como o **VS Code** ou IntelliJ).
3. Compile e execute a classe principal localizada em `src/ui/Main.java`.
4. Utilize o menu interativo no terminal para testar os cadastros, turmas, notas e relatórios.