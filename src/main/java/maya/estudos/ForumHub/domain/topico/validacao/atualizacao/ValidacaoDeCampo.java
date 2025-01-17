package maya.estudos.ForumHub.domain.topico.validacao.atualizacao;

import maya.estudos.ForumHub.domain.topico.DadosTopicoAtualizacao;
import maya.estudos.ForumHub.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoDeCampo implements ValidacaoAtualizacaoTopico{
    @Override
    public void validar(Long id, DadosTopicoAtualizacao dados) {
        if( dados.titulo() == null && dados.mensagem() == null){
            throw new ValidacaoException("É necessário informar ao menos um campo para atualização");
        }
    }
}
