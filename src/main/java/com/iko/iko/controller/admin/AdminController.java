package com.iko.iko.controller.admin;

import com.iko.iko.common.response.Response;
import com.iko.iko.controller.product.dto.ProductRequest.ProductSaveRequest;
import com.iko.iko.service.product.facade.ProductFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final ProductFacade productFacade;

    @PostMapping("insertProduct")
    public ResponseEntity<Response<String>> insertProduct(
            @Valid @RequestBody ProductSaveRequest productSaveRequest
    ) {
        return ResponseEntity.ok(
                Response.of(
                        productFacade.saveProductService(productSaveRequest),
                        "OK"
                )
        );
    }

}
