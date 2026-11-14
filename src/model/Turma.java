package model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private List<Aluno> listaAlunos;

    // Construtor
    public Turma(String codigo, Professor professor, Curso curso) {
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
        this.listaAlunos = new ArrayList<>();
    }

    // Método para adicionar aluno à turma
    public void adicionarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
        System.out.println("-> Aluno(a) " + aluno.getNome() + " foi matriculado(a) na turma " + codigo + ".");
    }

    // Método para remover aluno da turma
    public void removerAluno(Aluno aluno) {
        if (listaAlunos.remove(aluno)) {
            System.out.println("-> Aluno(a) " + aluno.getNome() + " foi removido(a) da turma " + codigo + ".");
        } else {
            System.out.println("-> Aluno(a) não encontrado(a) nesta turma.");
        }
    }

    // Método para mostrar o resumo completo da turma
    public void mostrarResumo() {
        System.out.println("\n========================================");
        System.out.println("         RESUMO DA TURMA: " + codigo);
        System.out.println("========================================");
        
        // CORREÇÃO AQUI: Usando o método polimórfico detalharCurso() da Fase 4
        curso.detalharCurso();
        
        System.out.print("Professor Responsável: ");
        professor.exibirInformacoes();
        
        System.out.println("Total de Alunos Matriculados: " + listaAlunos.size());
        System.out.println("Lista de Alunos:");
        if (listaAlunos.isEmpty()) {
            System.out.println("  (Nenhum aluno matriculado no momento)");
        } else {
            for (Aluno a : listaAlunos) {
                System.out.print("  - ");
                a.exibirInformacoes();
            }
        }
        System.out.println("========================================");
    }

    // Getters
    public String getCodigo() { return codigo; }
    public Professor getProfessor() { return professor; }
    public Curso getCurso() { return curso; }
    public List<Aluno> getListaAlunos() { return listaAlunos; }
}
