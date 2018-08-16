package br.com.gustavolaviola.gapisendereco.controlher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.gustavolaviola.gapisendereco.model.Endereco;

public class GapisRestController<T,ID> {
	
	private CrudRepository<T, ID> grudRepository;

	@Autowired
	public GapisRestController(CrudRepository<T, ID> grudRepository){
		this.grudRepository = grudRepository;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<?>> getEndereco() {
		return new ResponseEntity<Iterable<?>>(grudRepository.findAll(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getEndereco(@PathVariable("id") ID id) {
		return new ResponseEntity<T>(grudRepository.findById(id).get(),HttpStatus.OK);
	}

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody T endereco){
        return new ResponseEntity<T>(grudRepository.save(endereco),HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}",method=RequestMethod.PUT)
    public ResponseEntity<?> put( @RequestBody T t){
        return new ResponseEntity<T>(grudRepository.save(t),HttpStatus.OK);
    }

    @RequestMapping(value = "/endereco/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id")ID id){
    	grudRepository.deleteById(id);
        return new ResponseEntity<Endereco>(HttpStatus.NO_CONTENT);
    }
}
