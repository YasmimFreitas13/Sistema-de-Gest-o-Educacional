package model;

public class CursoPresencial extends Curso {
    private String salaAula;

    public CursoPresencial(String nome, String codigo, int cargaHoraria, String salaAula) {
        super(nome, codigo, cargaHoraria);
        this.salaAula = salaAula;
    }

    @Override
    public void detalharCurso() {
        System.out.println("[Presencial] " + nome + " | Código: " + codigo + " | Carga: " + cargaHoraria + "h | Sala: " + salaAula);
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("----------------------------------------");
        System.out.println("📊 RELATÓRIO DE CURSO PRESENCIAL");
        System.out.println("Curso: " + nome + " | Sala de Aula: " + salaAula);
        System.out.println("----------------------------------------");
    }

    public String getSalaAula() { return salaAula; }
}