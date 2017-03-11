package gov.goias.sat2.conf;

import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

@Component
public class WebApp extends ResourceConfig {
    private static final Logger LOG = Logger.getLogger(WebApp.class);

    public WebApp() {
        packages("gov.goias");
    }

    /**
     * Obtem ordem de parametros para paginação usando www.datatables.net/
     * @param request HttpRequest
     * @param columns lista de colunas da tabela
     * @return mapa ordenado
     */
    public static Map<String,String> getPaginationOrder(final HttpServletRequest request, final String... columns){
        final Map<String,String> order = new LinkedHashMap<>();
        IntStream.range(0, columns.length).forEach(i -> {
            try{
                final String colIndex = request.getParameterValues(String.format("order[%s][column]",i))[0];
                final String pValue = request.getParameterValues(String.format("order[%s][dir]", i))[0];
                if(pValue != null && !"".equals(pValue))
                    order.put(columns[Integer.parseInt(colIndex)],pValue);
            }catch (Exception e){
                LOG.debug(e);
            }
        });
        return order;
    }

}