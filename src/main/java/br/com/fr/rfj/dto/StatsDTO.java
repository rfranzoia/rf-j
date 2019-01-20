package br.com.fr.rfj.dto;

import java.io.Serializable;

public class StatsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int savedUrls;
	private int baseUrlsCounter;
	private int protocolsCounter;

	public int getSavedUrls() {
		return savedUrls;
	}

	public void setSavedUrls(int savedUrls) {
		this.savedUrls = savedUrls;
	}

	public int getBaseUrlsCounter() {
		return baseUrlsCounter;
	}

	public void setBaseUrlsCounter(int baseUrlsCounter) {
		this.baseUrlsCounter = baseUrlsCounter;
	}

	public int getProtocolsCounter() {
		return protocolsCounter;
	}

	public void setProtocolsCounter(int protocolsCounter) {
		this.protocolsCounter = protocolsCounter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + baseUrlsCounter;
		result = prime * result + protocolsCounter;
		result = prime * result + savedUrls;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatsDTO other = (StatsDTO) obj;
		if (baseUrlsCounter != other.getBaseUrlsCounter())
			return false;
		if (protocolsCounter != other.getProtocolsCounter())
			return false;
		if (savedUrls != other.getSavedUrls())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "{ \"savedUrls\":" + savedUrls 
				+ ", \"baseUrlsCounter\":" + baseUrlsCounter 
				+ ", \"protocolsCounter\":" + protocolsCounter 
				+ "}";
	}
}
