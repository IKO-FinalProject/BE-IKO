package com.iko.iko.controller.product;

import java.util.List;

import com.iko.iko.controller.ProductDetails.dto.ProductDetailsResponse;
import com.iko.iko.controller.product.dto.ProductResponse;
import com.iko.iko.domain.entity.Product;
import com.iko.iko.service.product.facade.ProductFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import com.iko.iko.common.response.Response;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductFacade productFacade;

    @GetMapping("/product")
    public ResponseEntity<Response<List<ProductDetailsResponse.MainProductForResponse>>>
    getMainProduct(
            @RequestParam(value="page") Integer page,
            @PageableDefault(size=9,page = 0) Pageable pageable
    ){
        return ResponseEntity.ok(
                Response.of(
                        productFacade.getMainProduct(pageable),
                        "모든상품 불러오기 완료"
                )
        );
    }
}
