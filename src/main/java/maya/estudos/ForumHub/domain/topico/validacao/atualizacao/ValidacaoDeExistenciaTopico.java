package maya.estudos.ForumHub.domain.topico.validacao.atualizacao;

import maya.estudos.ForumHub.domain.topico.DadosTopicoAtualizacao;
import maya.estudos.ForumHub.domain.topico.TopicoRepository;
import maya.estudos.ForumHub.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoDeExistenciaTopico implements ValidacaoAtualizacaoTopico{

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(Long id, DadosTopicoAtualizacao dados) {
        var topico = topicoRepository.findById(id);

        if(topico.isEmpty()) {
            throw new ValidacaoException("Informe um ID do topico valido.");
        }
    }
}
