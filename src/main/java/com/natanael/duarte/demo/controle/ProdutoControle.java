package com.natanael.duarte.demo.controle;

import com.natanael.duarte.demo.modelo.ProdutoEntity;
        import com.natanael.duarte.demo.repositorio.ProdutoRepositorio;
        import org.apache.catalina.connector.Response;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpHeaders;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/prod")
public class  ProdutoControle {  //classe controladora


    @Autowired
    private ProdutoRepositorio  produtoRepositorio;

    @GetMapping
    public ResponseEntity<List<ProdutoEntity>> findAll (){  // get
        return new ResponseEntity<List<ProdutoEntity>>(
                (List<ProdutoEntity>) this.produtoRepositorio.findAll(),
                new HttpHeaders(), HttpStatus.OK);//error 404
    }

    @GetMapping(path = "/{id}")

    public ResponseEntity<ProdutoEntity> findById(@PathVariable ("id") long id) {
        if(this.produtoRepositorio.findById(id).isPresent()){
            return new ResponseEntity<ProdutoEntity>(
                    this.produtoRepositorio.findById(id).get(),
                    new HttpHeaders(),
                    HttpStatus.OK);

        }
        return new ResponseEntity<ProdutoEntity>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<ProdutoEntity> cadastrar (@RequestBody ProdutoEntity produtoEntity) {
        return new ResponseEntity<ProdutoEntity> (
                this.produtoRepositorio.save(produtoEntity),
                new HttpHeaders(),
                HttpStatus.CREATED
        );

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoEntity> atualizar (@PathVariable("id") long id,
                                                        @RequestBody ProdutoEntity produtoEntity) throws Exception {

        if(id == 0 || !this.produtoRepositorio.existsById(id)){
            throw  new Exception("Código não encontrado ou inexistente!");

        }
        return new ResponseEntity<ProdutoEntity>(
                this.produtoRepositorio.save(produtoEntity),
                new HttpHeaders(),
                HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ProdutoEntity> deletar (@PathVariable("id") long id ){
        this.produtoRepositorio.deleteById(id);
        return new ResponseEntity<ProdutoEntity>(new HttpHeaders(), HttpStatus.OK);
    }

}