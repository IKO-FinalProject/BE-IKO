package com.iko.iko.service.productDetails;

import com.iko.iko.common.exception.BaseException;
import com.iko.iko.common.response.ErrorCode;
import com.iko.iko.controller.product.dto.ProductRequest.ProductSaveRequest;
import com.iko.iko.controller.product.dto.ProductRequest.ProductSaveRequest.ProductOptionSaveRequest;
import com.iko.iko.domain.entity.Image;
import com.iko.iko.domain.entity.LinkProductDetailsImage;
import com.iko.iko.domain.entity.Product;
import com.iko.iko.domain.entity.ProductDetails;
import com.iko.iko.domain.repository.Image.ImageRepository;
import com.iko.iko.domain.repository.linkProductDetailsImage.LinkProductDetailsImageRepository;
import com.iko.iko.domain.repository.product.ProductRepository;
import com.iko.iko.domain.repository.productDetails.ProductDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SaveProductService {
    private final ProductRepository productRepository;
    private final ProductDetailsRepository productDetailsRepository;
    private final ImageRepository imageRepository;
    private final LinkProductDetailsImageRepository linkProductDetailsImageRepository;

    @Transactional
    public String saveProductService(ProductSaveRequest productSaveRequest) {
        Product product = productRepository.save(productSaveRequest.toEntity());
        if(product.getProductId() == null) {
            throw new BaseException(ErrorCode.COMMON_BAD_REQUEST);
        }

        int idx = 0;
        for(ProductOptionSaveRequest productOptionSaveRequest : productSaveRequest.getProductOptionSaveRequestList()) {
            ProductDetails productDetails = productOptionSaveRequest.toEntity();
            productDetails.setProductIdFk(product.getProductId());
            productDetails.setDegree(productOptionSaveRequest.getDegree().get(idx));
            ProductDetails newProductDetails = productDetailsRepository.save(productDetails);
            if(newProductDetails.getProductDetailsId() == null) {
                throw new BaseException(ErrorCode.COMMON_BAD_REQUEST);
            }

            Image image = new Image();
            image.setImageUrl(productOptionSaveRequest.getImageUrl().get(idx));
            image.setImageType(1);
            Image newImage = imageRepository.save(image);
            if(newImage.getImageId() == null) {
                throw new BaseException(ErrorCode.COMMON_BAD_REQUEST);
            }

            LinkProductDetailsImage linkProductDetailsImage = new LinkProductDetailsImage();
            linkProductDetailsImage.setProductDetailsId(newProductDetails.getProductDetailsId());
            linkProductDetailsImage.setImageId(newImage.getImageId());
            LinkProductDetailsImage newLinkProductDetailsImage = linkProductDetailsImageRepository.save(linkProductDetailsImage);
            if(newLinkProductDetailsImage.getProductDetailsId() == null) {
                throw new BaseException(ErrorCode.COMMON_BAD_REQUEST);
            }

            idx++;
        }

        return "OK";
    }
}
