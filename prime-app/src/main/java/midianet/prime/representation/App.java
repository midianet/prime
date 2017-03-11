package midianet.prime.representation;

import lombok.Data;

@Data
public class App {
    private Integer id;
    private String sigla;
    private String descricao;
    private String conexao;
    private String mensagem;
    private String logotipo;
    private String nomeAplicacao;
}