package maya.estudos.ForumHub.domain.topico.validacao.criacao;

import maya.estudos.ForumHub.domain.curso.CursoRepository;
import maya.estudos.ForumHub.domain.topico.DadosTopicoCadastro;
import maya.estudos.ForumHub.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoDoCurso implements ValidacaoCriacaodeTopico {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void validar(DadosTopicoCadastro dados) {
        var curso = cursoRepository.findByNomeIgnoreCase(dados.nomeCurso());
        if (curso == null) {
            throw new ValidacaoException("Curso não encontrado: " + dados.nomeCurso());
        }

    }
}
