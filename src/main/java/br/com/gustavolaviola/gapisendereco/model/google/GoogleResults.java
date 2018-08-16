package br.com.gustavolaviola.gapisendereco.model.google;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleResults
{
    private String place_id;
    private GoogleAddressComponents[] address_components;
    private String formatted_address;
    private String[] types;
    private GoogleGeometry geometry;
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	public GoogleAddressComponents[] getAddress_components() {
		return address_components;
	}
	public void setAddress_components(GoogleAddressComponents[] address_components) {
		this.address_components = address_components;
	}
	public String getFormatted_address() {
		return formatted_address;
	}
	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}
	public String[] getTypes() {
		return types;
	}
	public void setTypes(String[] types) {
		this.types = types;
	}
	public GoogleGeometry getGeometry() {
		return geometry;
	}
	public void setGeometry(GoogleGeometry geometry) {
		this.geometry = geometry;
	}
    
    
}