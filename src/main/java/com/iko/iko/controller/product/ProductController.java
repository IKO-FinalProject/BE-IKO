package com.iko.iko.controller.product;

import java.util.ArrayList;
import java.util.List;

import com.iko.iko.controller.product.dto.ProductResponse;
import com.iko.iko.domain.entity.Product;
import com.iko.iko.domain.repository.product.ProductRepository;
import com.iko.iko.service.product.facade.ProductFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import com.iko.iko.common.response.Response;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductFacade productFacade;

//    public ProductController(ProductFacade productFacade) {
//        this.productFacade = productFacade;
//    }

/*
    @GetMapping("/productMain")
    public List<Product> getMainProduct(Pageable pageable){
        return null;ResponseEntity.ok(
                Response.of(
                        productFacade.getMainProduct(pageable),
                        "불러오기 완료"
                )
        );
    }*/
/*
    @GetMapping("/mainProduct")
    public ResponseEntity<Response<List<ProductResponse.ProductMainResponse>>>
    getMainProduct(
            @PageableDefault(size = 9, page = 0) Pageable pageable
    ) {
        return ResponseEntity.ok(
                Response.of(
                        productFacade.getMainProduct(pageable),
                        "메인상품 불러오기 완료"
                )
        );

    }
    @GetMapping("/allProduct")
    public ResponseEntity<Response<List<ProductResponse.AllProduct>>>
    getProduct(
            @PageableDefault(size=9,page=0)Pageable pageable
    ){
        return ResponseEntity.ok(
                Response.of(
                        productFacade.getAllProduct(pageable),
                "모든상품 불러오기 완료"
                )
        );
    }*/

}
