package service;

import model.*;
import repository.SistemaRepository;

public class SistemaService {

    public static void cadastrarUsuario(Usuario usuario) {
        SistemaRepository.usuarios.add(usuario);
        System.out.println("-> [Sucesso]: Usuário " + usuario.getNome() + " cadastrado com sucesso!");
    }

    public static void cadastrarCurso(Curso curso) {
        SistemaRepository.cursos.add(curso);
        System.out.println("-> [Sucesso]: Curso " + curso.getNome() + " cadastrado com sucesso!");
    }

    public static void cadastrarTurma(Turma turma) {
        SistemaRepository.turmas.add(turma);
        System.out.println("-> [Sucesso]: Turma " + turma.getCodigo() + " criada com sucesso!");
    }

    public static Usuario autenticarUsuario(String login, String senha) {
        for (Usuario u : SistemaRepository.usuarios) {
            if (u.autenticar(login, senha)) {
                return u;
            }
        }
        return null;
    }
}