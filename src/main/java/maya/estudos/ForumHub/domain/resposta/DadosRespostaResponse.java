package maya.estudos.ForumHub.domain.resposta;

import java.time.LocalDateTime;

public record DadosRespostaResponse(
        Long id,
        String mensagem,
        String solucao,
        String nomeAutor,
        LocalDateTime dataCriacao
) {

    public DadosRespostaResponse(Resposta respostaSalva) {
        this(
                respostaSalva.getId(),
                respostaSalva.getMensagem(),
                respostaSalva.getSolucao(),
                respostaSalva.getAutor().getNome(),
                respostaSalva.getDataCriacao());
    }
}
