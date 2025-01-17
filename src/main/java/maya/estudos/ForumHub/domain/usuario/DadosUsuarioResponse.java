package maya.estudos.ForumHub.domain.usuario;

public record DadosUsuarioResponse(
        Long id,
        String nome,
        String email
) {
    public DadosUsuarioResponse(Usuario novoUsuario) {
        this(
                novoUsuario.getId(),
                novoUsuario.getNome(),
                novoUsuario.getEmail());
    }
}
