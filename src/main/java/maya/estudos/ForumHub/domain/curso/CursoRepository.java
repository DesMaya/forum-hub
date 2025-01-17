package maya.estudos.ForumHub.domain.curso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    // procurar por nome ignorando case
    Curso findByNomeIgnoreCase(String nome);
}

