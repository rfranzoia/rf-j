package br.com.fr.rfj.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import br.com.fr.rfj.exception.ShortnerException;
import br.com.fr.rfj.model.ShortUrl;
import br.com.fr.rfj.util.KeyGenerator;

@Service
public class ShortnerService {

	private final Logger logger = Logger.getLogger(getClass());
	public static final String REGEX = "([0-9]{4})([0-9]{2})";

	private static final String BASE_URL = "rf.j";

	private static HashMap<String, ShortUrl> savedUrls = new LinkedHashMap<>();

	// lista todas urls guardadas
	public List<String> listAll() throws ShortnerException {
		List<String> list = new ArrayList<>();
		savedUrls
			.values()
			.forEach(su -> {
				list.add(su.toString());
			});
		return list;
	}

	public String showStats() {
		return "";
	}

	public String urlShort(String url) throws ShortnerException {
		logger.info("urlShort");
		
		Base64.Encoder encoder = Base64.getEncoder();

		String noProtocolUrl = url.replaceAll("http[s]://", "");
		String protocol = url.substring(0, url.indexOf("//") + 2);
		
		String baseURL = "";
		String urlPATH = "";
		
		if (noProtocolUrl.indexOf('/') > 0) {
			baseURL = noProtocolUrl.substring(0, noProtocolUrl.indexOf('/'));
			urlPATH = noProtocolUrl.substring(noProtocolUrl.indexOf('/'));
		} else {
			baseURL = noProtocolUrl;
		}

		String encodedURL = encoder.encodeToString(url.getBytes());
		ShortUrl su = savedUrls.get(encodedURL);
		
		if (su == null) {
			String key = KeyGenerator.generateKey(8);
			
			su = new ShortUrl();
			su.setKey(key);
			su.setProtocol(protocol);
			su.setBaseUrl(baseURL);
			su.setUrlPath(urlPATH);
			
			savedUrls.put(encodedURL, su);
			
		}

		return (protocol + BASE_URL + "/" + su.getKey());

	}

	public String getUrlByKey(String url) {
		logger.info("getUrlByKey");
		
		//String noProtocolUrl = url.replaceAll("http[s]://", "");
		//String key = noProtocolUrl.substring(noProtocolUrl.indexOf(BASE_URL + "/") + 5);

		for (ShortUrl su : savedUrls.values()) {
			if (su.getKey().equals(url)) {
				String savedUrl = su.getProtocol() + su.getBaseUrl() + su.getUrlPath();
				return savedUrl;
			}
		}
		
		return null;
	}

}
