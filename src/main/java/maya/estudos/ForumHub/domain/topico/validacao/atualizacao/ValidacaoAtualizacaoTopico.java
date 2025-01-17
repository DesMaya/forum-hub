package maya.estudos.ForumHub.domain.topico.validacao.atualizacao;


import maya.estudos.ForumHub.domain.topico.DadosTopicoAtualizacao;

public interface ValidacaoAtualizacaoTopico {
    void validar(Long id, DadosTopicoAtualizacao dados);
}
