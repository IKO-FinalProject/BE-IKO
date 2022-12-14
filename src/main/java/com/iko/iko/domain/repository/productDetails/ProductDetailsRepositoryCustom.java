package com.iko.iko.domain.repository.productDetails;

import com.iko.iko.controller.ProductDetails.dto.ProductDetailsResponse;
import com.iko.iko.controller.product.dto.ProductResponse;
import com.iko.iko.controller.product.dto.request.ProductRequest;
import com.iko.iko.domain.entity.Product;
import org.springframework.data.domain.Pageable;
import com.iko.iko.controller.ProductDetails.dto.ProductDetailsRequest;

import java.util.List;

public interface ProductDetailsRepositoryCustom {

    List<ProductDetailsResponse.GetColorCodeAndImageUrl> getColorAndImage(Integer selectedProductId);

    List<ProductDetailsResponse.GetGraphicDiameter> getGraphic(Integer selectedProductId);

    List<ProductDetailsResponse.MainProduct> getMainProduct(Pageable pageable, Integer productId);

    List<Integer> getProductIdByMainOption
            (ProductDetailsRequest.ProductOptionForRequest productByOption);

    List<ProductDetailsResponse.ProductDetails> getProductDetails(Integer selectedProductId);

    List<ProductDetailsResponse.typeAndImage> getTypeAndImageForProductDetailsId(Integer selectedProductDetailsId);

    List<ProductDetailsResponse.ListInfoForProductDetails> getListInfoForDetails(Integer selectedProductDetailsId);

    List<Integer> getProductByProductOption(ProductDetailsRequest.ProductOptionForRequest productOptionForRequest);

    List<ProductDetailsResponse.typeAndImage> getTypeAndImageByProductId(Integer selectedProductId);

    List<ProductDetailsResponse.ProductDetailsFilterList> getDetailsFilterInfo();

    List<String> getExplainImageByProductId(Integer productId);


    List<ProductDetailsResponse.ByPeriodOption> getPeriodOption(Integer productId, Integer period);

    List<Float> getColorCodeOption(Integer productId, Integer period, String colorCode);

    List<ProductDetailsResponse.DegreeAndStock> getGraphicOption(Integer productId, Integer period, String colorCode, Float graphic);


    //List<ProductDetailsResponse.DegreeAndStock> getProductDetailsByOption(ProductDetailsRequest.ProductDetailsForRequest option);
    Integer getProductDetailsIdByOption(ProductDetailsRequest.ProductDetailsForRequest request);

    ProductDetailsResponse.ProductDetailsByOption getProductDetailsByProductDetailsId(
            Integer productDetailsId
    );

    List<Integer> getProductDetailsIdByProductIdForBest(
            Integer productId
    );

    List<ProductResponse.ProductDetailsInfo> getProductDetailsForAdmin(Integer productId);

    List<Float> getDegreeForAdmin(Integer productId, String color);

    Long deleteProductDetails(Integer productId);

    List<Integer> searchProductDetailsIdByProductId(Integer productId);

    List<ProductResponse.stockListResponse> getStockAndDegree(Integer productId, String color, Integer period, Float graphicDiameter);

    Long updateStock(Integer productDetailsId, Integer stock);
}
