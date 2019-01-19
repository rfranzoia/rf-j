package br.com.fr.rfj;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import br.com.fr.rfj.web.ShortUrlREST;

/**
 * @author Romeu Franzoia Jr
 */
@Configuration
@ApplicationPath("api")
public class Config extends ResourceConfig {

    public Config() {
    	register(ShortUrlREST.class);
    }


}