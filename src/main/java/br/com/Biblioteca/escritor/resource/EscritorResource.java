package br.com.Biblioteca.escritor.resource;

import br.com.Biblioteca.escritor.domain.Escritor;
import br.com.Biblioteca.escritor.service.EscritorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.ClassUtils.isPresent;

@RestController
@RequestMapping(value = "/escritor")
public class EscritorResource {

    @Autowired
    private EscritorService escritorService;

    @PostMapping
    public ResponseEntity<Escritor> adicionarEscritor(@RequestBody Escritor escritorNovo){
        Escritor escritorAdicionado = escritorService.adicionarEscritor(escritorNovo);
        return new ResponseEntity<>(escritorAdicionado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Escritor>> listarEscritor(){
        List<Escritor> escritor = escritorService.listarEscritor();
        return ResponseEntity.ok(escritor);
    }

    @GetMapping("/{idEscrittor}")
    public ResponseEntity<Escritor> buscarEscritor(@PathVariable Integer idEscritor){
        return escritorService.buscarEscritor(idEscritor)
                .map(escritor -> new ResponseEntity<>(escritor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    @DeleteMapping("/{idPet}")
    public ResponseEntity<Void> deletarEscritor(@PathVariable Integer idEscritor){
        escritorService.deletarEscritor(idEscritor);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping
    public ResponseEntity<Escritor> atualizarEscritor(@PathVariable Integer idEscritor, @RequestBody Escritor escritor){
        if (EscritorService.buscarEscritor(idEscritor) isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        escritor.setId(idEscritor);
        Escritor novoEscritor = escritorService.atualizarEscritor(escritor);
        return new ResponseEntity<>(novoEscritor, HttpStatus.OK);
    }
}
