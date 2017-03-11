package midianet.prime.services;

import midianet.exception.InfraException;
import midianet.prime.entities.Aluno;
import midianet.prime.repositories.AlunoRepository;
import javaslang.collection.List;
import javaslang.control.Try;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

import static org.springframework.data.jpa.domain.Specifications.where;

@Service
public class AlunoService{
    private final Logger log = Logger.getLogger(getClass());

    @Autowired
    private AlunoRepository repository;

    public Optional<Aluno> obterPorId(final Long id) {

        return Try.of(() -> repository.findOne(id))
                .map(e -> Optional.ofNullable(e))
                .onFailure(InfraException::raise)
                .get();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void remover(final Long id) {
        try {
            obterPorId(id).ifPresent(aluno -> repository.delete(aluno));
        } catch (Exception e) {
            throw new InfraException(e);
        }
    }

    public Page<Aluno> listarPaginado(final Long id, final String nome, final String email, final PageRequest page) {
        List<Specification<Aluno>> specs = List.empty();
        //specs = id != null && id > 0? specs.append(id(id)) : specs;
        //specs = Strings.isNullOrEmpty(nome)? specs : specs.append(nomeIniciando(nome));
        //specs = Strings.isNullOrEmpty(email)? specs : specs.append(comEmail(email));
        final boolean noSpec = specs.isEmpty();
        final Specification<Aluno> spec = noSpec? null : specs.reduce((a1, a2) -> where(a1).and(a2));
        return Try.of(() -> noSpec? repository.findAll(page) : repository.findAll(spec, page))
                .onFailure(InfraException::raise)
                .get();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public Aluno salvar(final Aluno aluno) {
        return Try.of(() -> repository.save(aluno))
                .onFailure(InfraException::raise)
                .get();
    }

    public long contarTodos() {
        return Try.of(() -> repository.count())
                .onFailure(InfraException::raise)
                .get();
    }

}