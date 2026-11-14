package model;

public class Avaliacao {
    private double nota;
    private String descricao;
    private Aluno aluno;

    // Construtor
    public Avaliacao(String descricao, Aluno aluno) {
        this.descricao = descricao;
        this.aluno = aluno;
        this.nota = 0.0; // Valor padrão inicial
    }

    // Método com encapsulamento e validação estrita (Regra da Fase 3)
    public void atribuirNota(double valor) {
        if (valor >= 0.0 && valor <= 10.0) {
            this.nota = valor;
            System.out.println("-> [Sucesso]: Nota " + valor + " atribuída à avaliação '" + descricao + "' do aluno(a) " + aluno.getNome() + ".");
        } else {
            System.out.println("-> [Erro de Validação]: A nota (" + valor + ") é inválida! Deve estar obrigatoriamente entre 0 e 10.");
        }
    }

    // Método para exibir informações da avaliação
    public void exibirInformacoes() {
        System.out.println("Avaliação: " + descricao + " | Aluno(a): " + aluno.getNome() + " | Nota Registrada: " + nota);
    }

    // Getters para consulta segura (sem setter direto para 'nota')
    public double getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public Aluno getAluno() {
        return aluno;
    }
}