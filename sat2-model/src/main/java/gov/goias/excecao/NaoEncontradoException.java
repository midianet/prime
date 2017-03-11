package gov.goias.excecao;

/**
 * Created by marcosfernandocosta on 10/03/17.
 */
public class NaoEncontradoException extends RuntimeException {

    public NaoEncontradoException(){
        super("Not Found");
    }

}
