package maya.estudos.ForumHub.domain.topico.validacao.criacao;

import maya.estudos.ForumHub.domain.topico.DadosTopicoCadastro;
import maya.estudos.ForumHub.domain.topico.Topico;
import maya.estudos.ForumHub.domain.topico.TopicoRepository;
import maya.estudos.ForumHub.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoDeTopico implements ValidacaoCriacaodeTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(DadosTopicoCadastro dados) {

        Topico topico = topicoRepository.findByTituloAndMensagemIgnoreCase(dados.titulo(), dados.mensagem());

        if (topico != null) {
            throw new ValidacaoException("Tópico já existente: " + dados.titulo());
        }

    }
}
