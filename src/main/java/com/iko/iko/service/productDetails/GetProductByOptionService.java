package com.iko.iko.service.productDetails;

import com.iko.iko.common.exception.BaseException;
import com.iko.iko.common.response.ErrorCode;
import com.iko.iko.controller.ProductDetails.dto.ProductDetailsResponse;
import com.iko.iko.controller.product.dto.ProductResponse;
import com.iko.iko.domain.entity.Member;
import com.iko.iko.domain.entity.Product;
import com.iko.iko.domain.repository.member.MemberRepository;
import com.iko.iko.domain.repository.product.ProductRepository;
import com.iko.iko.domain.repository.productDetails.ProductDetailsRepository;
import com.iko.iko.security.jwt.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.iko.iko.controller.ProductDetails.dto.ProductDetailsRequest;

import java.util.*;
import java.util.Map.Entry;
import java.util.Comparator;

@Service
@RequiredArgsConstructor
public class GetProductByOptionService {

    private final ProductDetailsRepository productDetailsRepository;
    private final ProductRepository productRepository;

    private final MemberRepository memberRepository;

    public ProductDetailsResponse.MainFilterProductData
    GetProductByOption (ProductDetailsRequest.ProductOptionForRequest productByOption, Integer memberId) {
        Integer isFavorite=0;

        List<ProductDetailsResponse.MainProductForResponseNotTotalCount> result = new ArrayList<>();
        List<Integer> productIdList = productDetailsRepository.getProductIdByMainOption(productByOption);
        Map<Integer, Integer> productIdAndCount=new HashMap<Integer, Integer>();

        //Get ProductId By Option List
        for(Integer idList : productIdList){

            List<Integer> productDetailsIdList =productDetailsRepository.getProductDetailsIdByProductIdForBest(idList);
            productIdAndCount.put(idList,(int)(long)productDetailsIdList.stream().count());

        }
        //Sort 인기순 Key : productId, Value : 주문량
        List<Map.Entry<Integer, Integer>> entryList=new ArrayList<Entry<Integer,Integer>>(productIdAndCount.entrySet());

        Collections.sort(entryList, new Comparator<Entry<Integer, Integer>>() {
            public int compare(Entry<Integer, Integer> obj1, Entry<Integer, Integer> obj2){
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
        Integer totalCount=entryList.size();

        for(Map.Entry<Integer,Integer> eList : entryList){
            Product mainProduct
                    =productRepository.getProductDistinctByProductId(eList.getKey());
            Integer productId=eList.getKey();
            List<ProductDetailsResponse.GetGraphicDiameter> graphicList = productDetailsRepository.getGraphic(productId);
            List<Float> gList = new ArrayList<>();
            List<ProductDetailsResponse.GetColorCodeAndImageUrl> iList = new ArrayList<>();

            List<ProductDetailsResponse.GetColorCodeAndImageUrl> k
                    = productDetailsRepository.getColorAndImage(productId);
            for(ProductDetailsResponse.GetColorCodeAndImageUrl ttpp: k){
                iList.add(ttpp);
            }

            //
            for(ProductDetailsResponse.GetGraphicDiameter tp : graphicList){
                gList.add(tp.getGraphicDiameter());
            }
            ProductDetailsResponse.MainProductForResponseNotTotalCount checkData
                    =new ProductDetailsResponse.MainProductForResponseNotTotalCount(
                    isFavorite,
                    productId,
                    mainProduct.getSeries(),
                    gList,
                    mainProduct.getPrice(),
                    mainProduct.getDiscount(),
                    iList);

            result.add(checkData);
        }
        ProductDetailsResponse.MainFilterProductData finalResult =new ProductDetailsResponse.MainFilterProductData(
                totalCount,
                result
        );

        return finalResult;
    }
    public Member validateLoginStatus() {
        return memberRepository.findByEmail(SecurityUtil.getLoginUserEmail())
                .orElseThrow(() -> new BaseException(ErrorCode.NEED_LOGIN));
    }

}
