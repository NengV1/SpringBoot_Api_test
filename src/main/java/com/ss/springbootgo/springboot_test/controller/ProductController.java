package com.ss.springbootgo.springboot_test.controller;

import com.ss.springbootgo.springboot_test.entity.Product;

import com.ss.springbootgo.springboot_test.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
public class ProductController extends CommonController {

    private final ProductService service;

    @GetMapping("/products")
        public List<Product> products(@RequestParam(required = false) Product.Status status) {
            log.info(() -> "Get all products " + status);
            return service.findAll(status);
        }

    @GetMapping("/products/{id}")

    public ResponseEntity<Product> product(@PathVariable Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-developer", "neng");


//        ResponseEntity.ok().body(service.find(id));
//        ResponseEntity.ok(service.find(id));
//        ResponseEntity.status(HttpStatus.OK).headers(headers).body(service.find(id));
//        new ResponseEntity(service.find(id), HttpStatus.OK);
//        new ResponseEntity(service.find(id),headers, HttpStatus.OK);

        return ResponseEntity.ok().headers(headers).body(service.find(id));
    }



    @PostMapping("/products")
    public Product save(@RequestBody Product product) {
        return service.save(product);
    }

    @PutMapping("/products")
    public Product replace(@RequestBody Product product) {
        return service.replace(product);
    }

    @PatchMapping("/products/{id}/score/{score}")
        public int updateScore(@PathVariable Long id, @PathVariable double score) {
            return service.updateScore(id, score);
        }

    @GetMapping("/products/vs/{exact}")
    ///products/vs/as?encode=as
    public void vs(
            @PathVariable String exact,
            @RequestParam String encode

    ) {
        log.info(() -> "value from path-variable :" + exact);
        log.info(() -> "value from request-param : " + encode);
    }


    @GetMapping("/products/date/{yMd}")
    public void date(
            @PathVariable
//            @DateTimeFormat(pattern = "yyyy-M-d")
                    LocalDate yMd,
            @RequestParam
//            @DateTimeFormat(pattern = "d-M-yyyy")
                    LocalDate dMy

    ) {
        log.info(() -> "date from path-variable : " + yMd);
        log.info(() -> "date from request-param : " + dMy);
    }



    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Long id) {

        service.delete(id);
    }

}
