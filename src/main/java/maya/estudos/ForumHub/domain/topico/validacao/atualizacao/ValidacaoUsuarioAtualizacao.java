package maya.estudos.ForumHub.domain.topico.validacao.atualizacao;

import maya.estudos.ForumHub.domain.topico.DadosTopicoAtualizacao;
import maya.estudos.ForumHub.domain.topico.Topico;
import maya.estudos.ForumHub.domain.topico.TopicoRepository;
import maya.estudos.ForumHub.domain.usuario.UsuarioService;
import maya.estudos.ForumHub.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoUsuarioAtualizacao implements ValidacaoAtualizacaoTopico{

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void validar(Long id, DadosTopicoAtualizacao dados) {
        Topico topico = topicoRepository.findById(id).orElse(null);

        if(topico.getAutor() != usuarioService.usuarioAtual()) {
            throw new ValidacaoException("Usuario nao autorizado para atualizar o topico.");
        }
    }
}
