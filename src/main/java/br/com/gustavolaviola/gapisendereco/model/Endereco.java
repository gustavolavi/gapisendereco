package br.com.gustavolaviola.gapisendereco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.gustavolaviola.gapisendereco.model.google.GoogleAddressComponents;
import br.com.gustavolaviola.gapisendereco.model.google.GoogleEndereco;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String cep;
	private String pais;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String numero;
	private String lat;
	private String lng;

	public Endereco() {
	}

	public Endereco(Long id, String cep, String pais, String logradouro, String complemento, String bairro,
			String cidade, String uf,String numero, String lat, String lng) {
		super();
		this.id = id;
		this.cep = cep;
		this.pais = pais;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.numero = numero;
		this.lat = lat;
		this.lng = lng;
	}

	public Endereco(String cep, String complemento, GoogleEndereco googleEndereco) {
		this.cep = cep;
		this.complemento = complemento;
		for (GoogleAddressComponents g : googleEndereco.getResults()[0].getAddress_components()) {
			switch (g.getTypes()[0]) {
			case "route":
				this.logradouro = g.getLong_name();
				break;
			case "political":
				this.bairro = g.getLong_name();
				break;
			case "administrative_area_level_2":
				this.cidade = g.getLong_name();
				break;
			case "administrative_area_level_1":
				this.uf = g.getShort_name();
				break;
			case "country":
				this.pais = g.getLong_name();
				break;
			}
		}

		this.lat = googleEndereco.getResults()[0].getGeometry().getViewport().getSouthwest().getLat();
		this.lng = googleEndereco.getResults()[0].getGeometry().getViewport().getSouthwest().getLng();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	

}
