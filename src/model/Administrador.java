package model;

public class Administrador extends Usuario {
    private String nivelAcesso;

    public Administrador(String nome, String login, String senha, String nivelAcesso) {
        super(nome, login, senha);
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Administrador: " + nome + " | Nível de Acesso: " + nivelAcesso);
    }

    // ADICIONE ESTE MÉTODO PARA RESOLVER O ERRO (Exigido pela classe abstrata Usuario)
    @Override
    public void gerarRelatorio() {
        System.out.println("----------------------------------------");
        System.out.println("📊 RELATÓRIO DO ADMINISTRADOR");
        System.out.println("Nome: " + nome + " | Nível de Acesso: " + nivelAcesso);
        System.out.println("----------------------------------------");
    }

    public String getNivelAcesso() { return nivelAcesso; }
}