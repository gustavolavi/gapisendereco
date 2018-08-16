package br.com.gustavolaviola.gapisendereco.model.google;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleGeometry
{
    private GoogleBounds bounds;
    private GoogleViewport viewport;
    private String location_type;
    private GoogleLocation location;
    
	public GoogleBounds getBounds() {
		return bounds;
	}
	public void setBounds(GoogleBounds bounds) {
		this.bounds = bounds;
	}
	public GoogleViewport getViewport() {
		return viewport;
	}
	public void setViewport(GoogleViewport viewport) {
		this.viewport = viewport;
	}
	public String getLocation_type() {
		return location_type;
	}
	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}
	public GoogleLocation getLocation() {
		return location;
	}
	public void setLocation(GoogleLocation location) {
		this.location = location;
	}
    
    
}