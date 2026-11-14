package model;

public class Professor extends Usuario {
    private String especialidade;
    private String registro;

    public Professor(String nome, String login, String senha, String especialidade, String registro) {
        super(nome, login, senha);
        this.especialidade = especialidade;
        this.registro = registro;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Professor: " + nome + " | Especialidade: " + especialidade + " | Registro: " + registro);
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("----------------------------------------");
        System.out.println("📊 RELATÓRIO DO PROFESSOR");
        System.out.println("Nome: " + nome);
        System.out.println("Registro: " + registro);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("----------------------------------------");
    }

    public String getEspecialidade() { return especialidade; }
    public String getRegistro() { return registro; }
}