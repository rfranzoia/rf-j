package br.com.fr.rfj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		logger.info("onApplicationEvent() ... ");
	}

}
