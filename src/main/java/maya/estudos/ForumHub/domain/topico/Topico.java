package maya.estudos.ForumHub.domain.topico;

import jakarta.persistence.*;
import maya.estudos.ForumHub.domain.curso.Curso;
import maya.estudos.ForumHub.domain.resposta.DadosRespostaResponse;
import maya.estudos.ForumHub.domain.resposta.Resposta;
import maya.estudos.ForumHub.domain.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private StatusTopico status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico", fetch = FetchType.LAZY)
    private List<Resposta> respostas = new ArrayList<>();



    public List<DadosRespostaResponse> getRespostas() {
        return respostas.stream().map(DadosRespostaResponse::new).toList();
    }

    public void atualizar(DadosTopicoAtualizacao atualizacao) {

        if (atualizacao.titulo() != null) {
            this.titulo = atualizacao.titulo();
        }

        if (atualizacao.mensagem() != null) {
            this.mensagem = atualizacao.mensagem();
        }
    }

    public void setStatus(StatusTopico statusTopico) {
        this.status = statusTopico;
    }



    // Construtores
    public Topico(DadosTopicoCadastro cadastro, Curso curso, Usuario autor) {
        this.titulo = cadastro.titulo();
        this.mensagem = cadastro.mensagem();
        this.dataCriacao = LocalDateTime.now();
        this.status = StatusTopico.NAO_RESPONDIDO;
        this.curso = curso;
        this.autor = autor;
    }

    public Topico() {}

    public Topico(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, StatusTopico status, Usuario autor, Curso curso, List<Resposta> respostas) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
        this.respostas = respostas;
    }


    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public StatusTopico getStatus() {
        return status;
    }

    public Usuario getAutor() {
        return autor;
    }

    public Curso getCurso() {
        return curso;
    }

}