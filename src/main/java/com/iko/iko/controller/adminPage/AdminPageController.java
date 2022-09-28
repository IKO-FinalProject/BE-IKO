package com.iko.iko.controller.adminPage;

import com.iko.iko.domain.entity.Product;
import com.iko.iko.domain.repository.product.ProductRepository;
import com.iko.iko.domain.repository.productDetails.ProductDetailsRepository;
import com.iko.iko.service.product.facade.ProductFacade;
import com.iko.iko.service.productDetails.facade.ProductDetailsFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
