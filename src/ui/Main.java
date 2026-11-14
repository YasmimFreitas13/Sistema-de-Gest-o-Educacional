package ui;

import model.*;
import repository.SistemaRepository;
import service.SistemaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        // Pré-cadastrando alguns dados iniciais para facilitar os testes
        SistemaService.cadastrarUsuario(new Aluno("Yasmim Freitas", "yasmim", "123", "20260123", "ADS"));
        SistemaService.cadastrarUsuario(new Professor("Carlos Eduardo", "carlos", "123", "POO", "REG-987"));
        SistemaService.cadastrarCurso(new CursoPresencial("Análise e Desenvolvimento de Sistemas", "ADS-01", 2400, "Lab 01"));

        do {
            System.out.println("\n==================================================");
            System.out.println("     SISTEMA DE GESTÃO EDUCACIONAL - EDUCONNECT");
            System.out.println("==================================================");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Cadastrar Curso (Presencial ou EAD)");
            System.out.println("4. Criar Turma e Associar Professor/Curso");
            System.out.println("5. Registrar Avaliação (Nota com Encapsulamento)");
            System.out.println("6. Gerar Relatórios Gerais (Polimorfismo)");
            System.out.println("7. Testar Autenticação (Interface)");
            System.out.println("0. Sair do Sistema");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Aluno: ");
                    String nomeA = scanner.nextLine();
                    System.out.print("Login: ");
                    String loginA = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senhaA = scanner.nextLine();
                    System.out.print("Matrícula: ");
                    String mat = scanner.nextLine();
                    System.out.print("Curso: ");
                    String cur = scanner.nextLine();
                    
                    Aluno novoAluno = new Aluno(nomeA, loginA, senhaA, mat, cur);
                    SistemaService.cadastrarUsuario(novoAluno);
                    break;

                case 2:
                    System.out.print("Nome do Professor: ");
                    String nomeP = scanner.nextLine();
                    System.out.print("Login: ");
                    String loginP = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senhaP = scanner.nextLine();
                    System.out.print("Especialidade: ");
                    String esp = scanner.nextLine();
                    System.out.print("Registro: ");
                    String reg = scanner.nextLine();

                    Professor novoProf = new Professor(nomeP, loginP, senhaP, esp, reg);
                    SistemaService.cadastrarUsuario(novoProf);
                    break;

                case 3:
                    System.out.print("Tipo de Curso (1 - Presencial | 2 - EAD): ");
                    int tipoC = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome do Curso: ");
                    String nomeC = scanner.nextLine();
                    System.out.print("Código: ");
                    String codC = scanner.nextLine();
                    System.out.print("Carga Horária: ");
                    int ch = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoC == 1) {
                        System.out.print("Sala de Aula: ");
                        String sala = scanner.nextLine();
                        SistemaService.cadastrarCurso(new CursoPresencial(nomeC, codC, ch, sala));
                    } else {
                        System.out.print("Plataforma Virtual: ");
                        String plat = scanner.nextLine();
                        SistemaService.cadastrarCurso(new CursoEAD(nomeC, codC, ch, plat));
                    }
                    break;

                case 4:
                    if (SistemaRepository.cursos.isEmpty() || SistemaRepository.usuarios.isEmpty()) {
                        System.out.println("-> [Aviso]: É necessário ter pelo menos um curso e um usuário cadastrados!");
                        break;
                    }
                    System.out.print("Código da Turma: ");
                    String codT = scanner.nextLine();
                    
                    // Pegando o primeiro professor e curso disponíveis para o exemplo
                    Professor profTurma = null;
                    Curso cursoTurma = SistemaRepository.cursos.get(0);
                    
                    for(Usuario u : SistemaRepository.usuarios) {
                        if(u instanceof Professor) {
                            profTurma = (Professor) u;
                            break;
                        }
                    }

                    if(profTurma == null) {
                        System.out.println("-> [Erro]: Nenhum professor cadastrado para associar à turma!");
                        break;
                    }

                    Turma novaTurma = new Turma(codT, profTurma, cursoTurma);
                    
                    // Adicionando alunos cadastrados à turma
                    for(Usuario u : SistemaRepository.usuarios) {
                        if(u instanceof Aluno) {
                            novaTurma.adicionarAluno((Aluno) u);
                        }
                    }

                    SistemaService.cadastrarTurma(novaTurma);
                    novaTurma.mostrarResumo();
                    break;

                case 5:
                    // Buscar um aluno para avaliar
                    Aluno alunoAlvo = null;
                    for(Usuario u : SistemaRepository.usuarios) {
                        if(u instanceof Aluno) {
                            alunoAlvo = (Aluno) u;
                            break;
                        }
                    }

                    if(alunoAlvo == null) {
                        System.out.println("-> [Erro]: Nenhum aluno cadastrado para receber avaliação.");
                        break;
                    }

                    System.out.print("Descrição da Avaliação (ex: Prova 1): ");
                    String desc = scanner.nextLine();
                    Avaliacao av = new Avaliacao(desc, alunoAlvo);

                    System.out.print("Digite a nota atribuída (0 a 10): ");
                    double valorNota = scanner.nextDouble();
                    av.atribuirNota(valorNota);
                    SistemaRepository.avaliacoes.add(av);
                    break;

                case 6:
                    System.out.println("\n================ RELATÓRIOS GERAIS ================");
                    System.out.println("--- Relatórios de Usuários ---");
                    for (Usuario u : SistemaRepository.usuarios) {
                        u.gerarRelatorio();
                    }
                    System.out.println("\n--- Relatórios de Cursos ---");
                    for (Curso c : SistemaRepository.cursos) {
                        c.gerarRelatorio();
                    }
                    break;

                case 7:
                    System.out.print("Digite o Login: ");
                    String l = scanner.nextLine();
                    System.out.print("Digite a Senha: ");
                    String s = scanner.nextLine();

                    Usuario logado = SistemaService.autenticarUsuario(l, s);
                    if (logado != null) {
                        System.out.println("-> [Sucesso]: Bem-vindo(a), " + logado.getNome() + "! Acesso concedido.");
                    } else {
                        System.out.println("-> [Falha]: Login ou senha incorretos.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o Sistema de Gestão Educacional... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Escolha entre 0 e 7.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}