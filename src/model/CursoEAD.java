package model;

public class CursoEAD extends Curso {
    private String plataformaVirtual;

    public CursoEAD(String nome, String codigo, int cargaHoraria, String plataformaVirtual) {
        super(nome, codigo, cargaHoraria);
        this.plataformaVirtual = plataformaVirtual;
    }

    @Override
    public void detalharCurso() {
        System.out.println("[EAD] " + nome + " | Código: " + codigo + " | Carga: " + cargaHoraria + "h | Plataforma: " + plataformaVirtual);
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("----------------------------------------");
        System.out.println("📊 RELATÓRIO DE CURSO EAD");
        System.out.println("Curso: " + nome + " | Plataforma: " + plataformaVirtual);
        System.out.println("----------------------------------------");
    }

    public String getPlataformaVirtual() { return plataformaVirtual; }
}