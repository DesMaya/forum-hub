package maya.estudos.ForumHub.domain.resposta;

import jakarta.persistence.*;
import maya.estudos.ForumHub.domain.topico.Topico;
import maya.estudos.ForumHub.domain.usuario.Usuario;

import java.time.LocalDateTime;

@Table(name = "respostas")
@Entity(name = "Resposta")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;
    private String solucao;



    public void atualizar(DadosRespostaAtualizacao resposta) {

        if(resposta.mensagem() != null){
            this.mensagem = resposta.mensagem();
        }

        if(resposta.solucao() != null){
            this.solucao = resposta.solucao();
        }
    }


    // Construtores

    public Resposta(Long id, String mensagem, LocalDateTime dataCriacao, Topico topico, Usuario autor, String solucao) {
        this.id = id;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
        this.topico = topico;
        this.autor = autor;
        this.solucao = solucao;
    }

    public Resposta() {}

    public Resposta(DadosRespostaCadastro dados, Object topico, Usuario usuario) {
    }


    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }
}
