package br.com.gustavolaviola.gapisendereco.controlher;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.gustavolaviola.gapisendereco.model.Endereco;
import br.com.gustavolaviola.gapisendereco.model.ViaCep;
import br.com.gustavolaviola.gapisendereco.model.google.GoogleEndereco;
import br.com.gustavolaviola.gapisendereco.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController extends GapisRestController<Endereco,Long>{

	private EnderecoRepository enderecoRepository;
	
	@Autowired
	public EnderecoController(EnderecoRepository enderecoRepository) {
		super(enderecoRepository);
		this.enderecoRepository = enderecoRepository;
	}
	
	@RequestMapping(value = "/cep/{cep}", method = RequestMethod.GET)
	public Endereco googleEndereco(@PathVariable("cep") String cep) {
		String viaCepUrl = new StringBuilder("http://viacep.com.br/ws/").append(cep).append("/json/").toString();
		ViaCep viaCep = new RestTemplate().getForObject(URI.create(viaCepUrl), ViaCep.class);

		String googleUrl = new StringBuilder("http://maps.googleapis.com/maps/api/geocode/json?address=")
				.append(viaCep.getLogradouro()).append(",")
				.append(viaCep.getBairro()).append(",")
				.append(viaCep.getUf()).toString().replace(" ", "%20");
		
		GoogleEndereco googleEndereco = new RestTemplate().getForObject(URI.create(googleUrl), GoogleEndereco.class);
		
		return new Endereco(viaCep.getCep(), viaCep.getComplemento(), googleEndereco);
	}
	
}
