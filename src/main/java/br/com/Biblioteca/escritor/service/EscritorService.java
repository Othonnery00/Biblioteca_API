package br.com.Biblioteca.escritor.service;

import br.com.Biblioteca.escritor.domain.Escritor;
import br.com.Biblioteca.escritor.repository.EscritorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EscritorService {
    @Autowired
    private static EscritorRepository escritorRepository;

    public Escritor adicionarEscritor(Escritor novoEscritor) {
        return escritorRepository.save(novoEscritor);
    }

    public List<Escritor> listarEscritor() {
        return escritorRepository.findAll();
    }

    public Escritor atualizarEscritor(Escritor escritor) {
        return escritorRepository.save(escritor);
    }

    public void deletarEscritor(Integer idEscritor){
        escritorRepository.deleteById(idEscritor);
    }

    public static Optional<Escritor> buscarEscritor(Integer idEscritor){
        return escritorRepository.findById(idEscritor);
    }
}