package maya.estudos.ForumHub.domain.curso;

import jakarta.persistence.*;

@Table(name = "cursos")
@Entity(name = "Curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;


// Construtores
    public Curso(Long id, String nome, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    public Curso() {}


// Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
