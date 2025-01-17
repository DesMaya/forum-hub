package maya.estudos.ForumHub.domain.usuario;

public record DadosNome(String nome) {

    public DadosNome(Usuario usuario) {
        this(usuario.getNome());
    }
}
