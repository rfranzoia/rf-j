package br.com.fr.rfj.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import br.com.fr.rfj.entity.dto.ResponseDTO;
import br.com.fr.rfj.exception.ShortnerException;
import br.com.fr.rfj.service.ShortnerService;

@Component
@Path("v1/shortner")
public class ShortnerREST extends BasicREST {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ShortnerService service;
	
	/**
	 * @api {get} /stats
	 *    List api statistics
	 *    
	 * @apiDescription
	 *    List the api statistics
	 *    
	 * @apiName stats
	 * 
	 * @apiGroup Shortner
	 *
	 * @apiSuccess {ResponseDTO} responseDTO	
	 *    Success message and statistics listed
	 *
	 */
	@GET
	@Path("/stats")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
    public Response stats() throws Exception {
        try {
            return Response.ok().entity(new ResponseDTO(Status.OK.getStatusCode(), service.showStats())).build();
        } catch (Exception e) {
			return badRequest(e);
		}
    }
	
	/**
	 * @api {post} /url
	 *    Short a given URL
	 *    
	 * @apiDescription
	 *    Short a given URL
	 *    
	 * @apiName urlShortner
	 * 
	 * @apiGroup Shortner
	 *
	 * @apiSuccess {ResponseDTO} responseDTO	
	 *    Success message and the shortned URL as string
	 *
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Path("/url")
	public Response urlShort(String url) throws Exception {
		try {
			String shortnedUrl = service.urlShort(url);
			return Response.ok().entity(new ResponseDTO(Status.OK.getStatusCode(), shortnedUrl)).build();
		} catch (ShortnerException e) {
			return badRequest(e);
		}
	}
	
}
	