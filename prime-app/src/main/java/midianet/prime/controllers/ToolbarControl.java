package midianet.prime.controllers;

import midianet.prime.representation.ToolbarRep;
import midianet.prime.representation.UsuarioRep;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import java.io.IOException;

@Controller
@Path("toolbar")
public class ToolbarControl {

    @Context
    private HttpServletRequest req;

    @GET
    public ToolbarRep toolbar() throws IOException {
        final String username = "Usuário Master";
        final UsuarioRep u = new UsuarioRep();
        u.setNomeUsuario(username);
        return new ToolbarRep(u);
    }

}