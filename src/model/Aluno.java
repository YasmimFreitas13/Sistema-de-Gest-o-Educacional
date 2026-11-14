package model;

public class Aluno extends Usuario {
    private String matricula;
    private String curso;

    public Aluno(String nome, String login, String senha, String matricula, String curso) {
        super(nome, login, senha);
        this.matricula = matricula;
        this.curso = curso;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Aluno: " + nome + " | Matrícula: " + matricula + " | Curso: " + curso);
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("----------------------------------------");
        System.out.println("📊 RELATÓRIO DO ALUNO");
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Curso Vinculado: " + curso);
        System.out.println("----------------------------------------");
    }

    public String getMatricula() { return matricula; }
    public String getCurso() { return curso; }
}