package midianet.prime.repositories;

import midianet.prime.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AlunoRepository extends JpaRepository<Aluno, Long>, JpaSpecificationExecutor {
//    Optional<Aluno> findById(Long id);
    //Page<Aluno> queryFirst10ByNome(final String nome, final Pageable pageable);
}