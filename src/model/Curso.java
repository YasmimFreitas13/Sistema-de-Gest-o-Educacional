package model;

public class Curso {
    protected String nome;
    protected String codigo;
    protected int cargaHoraria;

    public Curso(String nome, String codigo, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    public void detalharCurso() {
        System.out.println("Curso Padrão: " + nome + " | Código: " + codigo + " | Carga Horária: " + cargaHoraria + "h");
    }

    public void gerarRelatorio() {
        System.out.println("----------------------------------------");
        System.out.println("📚 RELATÓRIO DO CURSO");
        System.out.println("Nome: " + nome + " | Código: " + codigo + " | Carga: " + cargaHoraria + "h");
        System.out.println("----------------------------------------");
    }

    public String getNome() { return nome; }
    public String getCodigo() { return codigo; }
    public int getCargaHoraria() { return cargaHoraria; }
}