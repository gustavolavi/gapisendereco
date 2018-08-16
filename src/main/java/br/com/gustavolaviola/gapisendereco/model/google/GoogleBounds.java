package br.com.gustavolaviola.gapisendereco.model.google;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleBounds
{
    private GoogleLatitudes southwest;
    private GoogleLatitudes northeast;
    
	public GoogleLatitudes getSouthwest() {
		return southwest;
	}
	public void setSouthwest(GoogleLatitudes southwest) {
		this.southwest = southwest;
	}
	public GoogleLatitudes getNortheast() {
		return northeast;
	}
	public void setNortheast(GoogleLatitudes northeast) {
		this.northeast = northeast;
	}
    
}