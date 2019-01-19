package br.com.fr.rfj.domain.shorturl;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ShortUrlRepository extends CrudRepository<ShortUrl, String>{

	@Query(nativeQuery = true, 
			value = "select short_url.* " + 
					"from short_url " + 
					"where short_url.encoded_url = :encodedurl ")
	public ShortUrl findByEncodedUrl(@Param("encodedurl") String encodedurl);
	
}
