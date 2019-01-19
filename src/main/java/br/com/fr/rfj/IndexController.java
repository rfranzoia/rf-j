package br.com.fr.rfj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fr.rfj.domain.shorturl.ShortUrlService;

@RestController
public class IndexController {

	@Autowired
	private ShortUrlService service;
	
    @RequestMapping(value = "/{shortennedUrl}", method = RequestMethod.GET)
    public String test(@PathVariable String shortennedUrl) {
    	String url = service.getUrlByKey(shortennedUrl);
    	if (url == null) {
    		return "<script>window.location = \"http://www.google.com\";</script>";
    	} else {
    		return "<script>window.location = \"" + url + "\"</script>";
    	}
    }

}