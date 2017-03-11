package midianet.prime.util;

import midianet.prime.view.model.Aluno;
import org.dozer.DozerBeanMapper;

public class DozerUtil {
    private static final DozerBeanMapper mapper = new DozerBeanMapper();

    static{
        mapper.addMapping(Aluno.getMappingBuilder());
    }

    public static DozerBeanMapper getMapper() {
        return mapper;
    }

}