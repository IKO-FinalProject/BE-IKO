package com.iko.iko.controller.admin;

import com.iko.iko.common.response.Response;
import com.iko.iko.controller.admin.dto.AdminRequest;
import com.iko.iko.controller.admin.dto.AdminResponse;
import com.iko.iko.service.product.facade.ProductFacade;
import com.iko.iko.controller.product.dto.request.ProductRequest.ProductSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final ProductFacade productFacade;

    @PostMapping("/insertProduct")
    public ResponseEntity<Response<String>> insertProduct(
            @RequestBody @Valid ProductSaveRequest productSaveRequest
    ){
        return ResponseEntity.ok(
                Response.of(
                        productFacade.saveProductService(productSaveRequest),
                        "상품 등록 완료"
                )
        );
    }

    @GetMapping("/productIdAndName")
    public ResponseEntity<Response<List<AdminResponse.ProductIdAndNameResponse>>> findProductIdAndName(
            @PageableDefault(size = 10, page=0) Pageable pageable
    ) {
        return ResponseEntity.ok(
                Response.of(
                        productFacade.findProductIdAndName(pageable),
                        "조회 완료"
                )
        );
    }

    @PostMapping("/updateProductDetails")
    public ResponseEntity<Response<String>> insertProduct(
            @RequestBody @Valid AdminRequest.ProductDetailsUpdateRequest productDetailsUpdateRequest
    ){
        return ResponseEntity.ok(
                Response.of(
                        productFacade.updateProductDetails(productDetailsUpdateRequest),
                        "OK"
                )
        );
    }

    @GetMapping("/allProductInfo")
    public ResponseEntity<Response<List<AdminResponse.AllProductInfoResponse>>> findAllProductInfo(
            @PageableDefault(size = 10, page = 0)Pageable pageable
    ) {
        return ResponseEntity.ok(
                Response.of(
                        productFacade.findAllProductInfo(pageable),
                        "조회 완료"
                )
        );
    }
}
