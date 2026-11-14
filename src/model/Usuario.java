package model;

public abstract class Usuario implements Autenticavel {
    protected String nome;
    protected String login;
    protected String senha;

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    @Override
    public boolean autenticar(String loginInserido, String senhaInserida) {
        return this.login.equals(loginInserido) && this.senha.equals(senhaInserida);
    }

    // Métodos abstratos exigidos pelas subclasses
    public abstract void gerarRelatorio();
    public abstract void exibirInformacoes();

    public String getNome() { return nome; }
    public String getLogin() { return login; }
}