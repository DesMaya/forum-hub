package maya.estudos.ForumHub.domain.resposta;

import jakarta.validation.constraints.NotBlank;

public record DadosRespostaCadastro(
        @NotBlank
        String mensagem,

        @NotBlank
        String solucao
) {
}
