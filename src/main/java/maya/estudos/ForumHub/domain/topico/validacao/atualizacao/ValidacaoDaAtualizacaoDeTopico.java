package maya.estudos.ForumHub.domain.topico.validacao.atualizacao;

import maya.estudos.ForumHub.domain.topico.DadosTopicoAtualizacao;
import maya.estudos.ForumHub.domain.topico.TopicoRepository;
import maya.estudos.ForumHub.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoDaAtualizacaoDeTopico implements ValidacaoAtualizacaoTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(Long id, DadosTopicoAtualizacao dados) {
        var topico = topicoRepository.findByTituloAndMensagemIgnoreCase(dados.titulo(), dados.mensagem());

        if(topico != null) {
            throw new ValidacaoException("Já existe um tópico com o mesmo título e mensagem");
        }
    }
}
