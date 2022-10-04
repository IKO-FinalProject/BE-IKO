package com.iko.iko.service.productDetails;

import com.iko.iko.common.exception.BaseException;
import com.iko.iko.common.response.ErrorCode;
import com.iko.iko.controller.ProductDetails.dto.ProductDetailsResponse;
import com.iko.iko.domain.repository.productDetails.ProductDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetMainProductDetailsService {
    private final ProductDetailsRepository productDetailsRepository;

    public List<ProductDetailsResponse.ProductDetailsForResponse> GetProductDetails(Integer selectedProductId) {

        List<ProductDetailsResponse.ProductDetailsForResponse> result=new ArrayList<>();

        List<ProductDetailsResponse.ProductDetails> productDetailsData
                = productDetailsRepository.getProductDetails(selectedProductId);
        List<Integer> periodList =new ArrayList<>();
        List<String> colorCodeList =new ArrayList<>();
        List<Float> graphicDiameterList =new ArrayList<>();
        List<Float> degreeList = new ArrayList<>();
        //set productData
        for(ProductDetailsResponse.ProductDetails detailsList : productDetailsData){
            ProductDetailsResponse.ProductDetailsForImageList imageLists
                    =new ProductDetailsResponse.ProductDetailsForImageList();
            ProductDetailsResponse.typeAndImageList typeTwo
                    =new ProductDetailsResponse.typeAndImageList(2,new ArrayList<>());

            List<ProductDetailsResponse.typeAndImage> typeAndImageData
                    =productDetailsRepository.getTypeAndImageForProductDetailsId(selectedProductId);
            for(ProductDetailsResponse.typeAndImage typeAndImageList : typeAndImageData){

                    if (typeAndImageList.getImageType().equals(1))
                    {
                        imageLists.setTypeOneImage(typeAndImageList);
                    }
                    else if (typeAndImageList.getImageType().equals(2))
                    {
                        typeTwo.getImageUrl().add(typeAndImageList.getImageUrl());
                    }
                    else if (typeAndImageList.getImageType().equals(3))
                    {
                        imageLists.setTypeThreeImage(typeAndImageList);
                    }
                    else throw new BaseException(ErrorCode.COMMON_BAD_REQUEST);


            }
            imageLists.setTypeTwoImage(typeTwo);
            List<ProductDetailsResponse.ListInfoForProductDetails> listInfoForProductDetailsList
                    =productDetailsRepository.getListInfoForDetails(detailsList.getProductDetailsId());
            for(ProductDetailsResponse.ListInfoForProductDetails detailsInfoList : listInfoForProductDetailsList){
                periodList.add(detailsInfoList.getPeriod());
                colorCodeList.add(detailsInfoList.getColorCode());
                graphicDiameterList.add(detailsInfoList.getDegree());
                degreeList.add(detailsInfoList.getDegree());
            }
            ProductDetailsResponse.ProductDetailsForResponse checkData
                    =new ProductDetailsResponse.ProductDetailsForResponse(
                    detailsList.getProductId(),
                    detailsList.getName(),
                    detailsList.getSeries(),
                    detailsList.getDetailsPrice(),
                    detailsList.getDiscount(),
                    periodList,
                    colorCodeList,
                    graphicDiameterList,
                    degreeList,
                    imageLists
            );
            result.add(checkData);
        }

        return result;
    }
}
