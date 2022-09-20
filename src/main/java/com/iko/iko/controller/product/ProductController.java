package com.iko.iko.controller.product;

import java.awt.print.Pageable;
import java.util.List;

import com.iko.iko.controller.product.dto.ProductResponse;
import com.iko.iko.domain.entity.Product;
import com.iko.iko.domain.repository.product.ProductRepository;
import com.iko.iko.service.product.GetProductMainService;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.iko.iko.common.response.Response;

import javax.persistence.OrderBy;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final GetProductMainService getProductMainService;
    @GetMapping("/mainProduct")
    public ResponseEntity<List<ProductResponse.ProductMainResponse>>
    getProductMain(
            @PageableDefault(size=10, page=0) Pageable pageable
    ){
        return ResponseEntity.ok(
                Response.of(
                        getProductMainService.getMainProduct(pageable),
                        "메인상품 불러오기 완료"
                )
        );
    }


}
