package maya.estudos.ForumHub.domain.usuario;

public record DadosUsuarioAtualizacao(
        String nome,
        String senha
) {
    public DadosUsuarioAtualizacao atualizarSenha(String senha) {
        return new DadosUsuarioAtualizacao(this.nome, senha);
    }
}