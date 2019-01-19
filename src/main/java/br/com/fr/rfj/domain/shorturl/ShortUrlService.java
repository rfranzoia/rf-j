package br.com.fr.rfj.domain.shorturl;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fr.rfj.util.KeyGenerator;

@Service
public class ShortUrlService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	public static final String REGEX = "([0-9]{4})([0-9]{2})";

	private static final String BASE_URL = "rf.j";

	@Autowired
	private ShortUrlRepository repository;

	// lista todas urls guardadas
	public List<String> listAll() throws ShortUrlException {
		List<String> list = new ArrayList<>();
		repository.findAll().forEach(su -> {
			list.add(su.toString());
		});
		return list;
	}

	public String showStats() {
		return "";
	}

	public String urlShort(String url) throws ShortUrlException {
		logger.info("urlShort");

		Base64.Encoder encoder = Base64.getEncoder();

		
		String protocol = "http://";
		if (url.indexOf("//") >= 0) {
			protocol = url.substring(0, url.indexOf("//") + 2);
		}

		String noProtocolUrl = url.replaceAll("http[s]://", "");
		String baseURL = "";
		String urlPATH = "";

		if (noProtocolUrl.indexOf('/') > 0) {
			baseURL = noProtocolUrl.substring(0, noProtocolUrl.indexOf('/'));
			urlPATH = noProtocolUrl.substring(noProtocolUrl.indexOf('/'));
		} else {
			baseURL = noProtocolUrl;
		}

		String encodedURL = encoder.encodeToString(url.getBytes());
		ShortUrl su = repository.findByEncodedUrl(encodedURL);

		if (su == null) {
			String id = KeyGenerator.generateKey(8);

			su = new ShortUrl();
			su.setId(id);
			su.setProtocol(protocol);
			su.setBaseUrl(baseURL);
			su.setUrlPath(urlPATH);
			su.setEncodedUrl(encodedURL);

			try {
				repository.save(su);
			} catch (Exception e) {
				logger.error(String.format("Could not save ShortUrl.\nError:%s", e.toString()));
			}

		}

		return (protocol + BASE_URL + "/" + su.getId());

	}

	public String getUrlByKey(String url) {
		logger.info("getUrlByKey");
		String savedUrl = null;

		// String noProtocolUrl = url.replaceAll("http[s]://", "");
		// String key = noProtocolUrl.substring(noProtocolUrl.indexOf(BASE_URL + "/") + 5);
		ShortUrl shortUrl = repository.findById(url).orElse(null);

		logger.info(String.format("ShortUrl on repository: %s", shortUrl.toString()));

		if (shortUrl != null) {
			savedUrl = shortUrl.getProtocol() + shortUrl.getBaseUrl() + shortUrl.getUrlPath();
		}

		return savedUrl;
	}

}
