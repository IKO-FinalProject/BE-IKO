package com.iko.iko.controller.adminPage;

import com.iko.iko.domain.repository.product.ProductRepository;
import com.iko.iko.domain.repository.productDetails.ProductDetailsRepository;
import com.iko.iko.service.product.facade.ProductFacade;
import com.iko.iko.service.productDetails.facade.ProductDetailsFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminPageController {
    private final ProductFacade productFacade;
    private final ProductDetailsFacade productDetailsFacade;

    @Autowired
    ProductRepository productRepository;
    ProductDetailsRepository productDetailsRepository;
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

    @GetMapping("/searchProductInfoByProductId")
    public List searchProductInfoBtProductId (int id) {
        List productList = entityManager.createQuery("SELECT (name, price, discount, diameter, manufacturer, " +
                        "series, feature, recommend, exposure) " +
                        "FROM Product " +
                        "WHERE productId = " + id).getResultList();

        return productList;
    }

    @GetMapping("/searchProductDetailsByProductId")
    public List searchProductDetailsByProductId (int id) {
        List productDetailsList = entityManager.createQuery("SELECT ((DISTINCT degree), graphicDiameter, basecurve, " +
                        "color, colorCode, material, detailsPrice, moisture, productDetailsStock, isSale, detailsExposure, period " +
                        "FROM ProductDetails " +
                        "WHERE productIdFk = " + id).getResultList();
        return productDetailsList;
    }
}
