package br.com.gustavolaviola.gapisendereco.model.google;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleEndereco{
    private GoogleResults[] results;
    private String status;
    
	public GoogleResults[] getResults() {
		return results;
	}
	public void setResults(GoogleResults[] results) {
		this.results = results;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
    
}
    