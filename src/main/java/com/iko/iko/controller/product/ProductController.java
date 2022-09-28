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

    @Autowired
    ProductRepository productRepository;
    EntityManager entityManager;

    //모든 productid, name을 넘기는 api
    @GetMapping("/searchAllProductNameAndProductId")
    public List searchProductNameAndProductId() {
        ArrayList resultList = new ArrayList();
        List resultNameList = entityManager.createQuery("SELECT name FROM Product")
                .getResultList();

        List resultIdList = entityManager.createQuery("SELECT productId FROM Product")
                .getResultList();

        for(int i=0; i<resultNameList.size(); i++) {
            Object[] temp = new Object[2];
            temp[0] = resultIdList.get(i);
            temp[1] = resultNameList.get(i);
            resultList.add(temp);
        }
        return resultList;
    }

    /*
    //product 정보 insert
    @GetMapping("/insertProductInfo")
    public String insertProductInfo(@RequestParam(value = "manufacturer") String manufacturer,
                                    @RequestParam(value = "series") String series,
                                    @RequestParam(value = "feature") String feature,
                                    @RequestParam(value = "discount") Integer discount,
                                    @RequestParam(value = "name") String name,
                                    @RequestParam(value = "price") Integer price,
                                    @RequestParam(value = "recommend") Integer recommend,
                                    @RequestParam(value = "exposure") Integer exposure,
                                    @RequestParam(value = "diameter") Float diameter) {
        Product entity = Product.builder().manufacturer(manufacturer).series(series).feature(feature)
                .discount(discount).name(name).price(price).recommend(recommend)
                .exposure(exposure).diameter(diameter).build();
        productRepository.save(entity);
        return "succes";
    }*/

    @PostMapping("/insertProductInfo")
    public void insertProductInfo(@RequestBody Product product) {

        Product newProduct = productRepository.save(product);

    }
}
