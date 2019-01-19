package br.com.fr.rfj;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import br.com.fr.rfj.rest.ShortnerREST;

/**
 * @author Romeu Franzoia Jr
 */
@Configuration
@ApplicationPath("api")
public class Config extends ResourceConfig {

    public Config() {
    	register(ShortnerREST.class);
    }


}