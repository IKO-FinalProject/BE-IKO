package com.iko.iko.controller.admin;

import com.iko.iko.common.response.Response;
import com.iko.iko.controller.ProductDetails.dto.ProductDetailsRequest;
import com.iko.iko.controller.ProductDetails.dto.ProductDetailsResponse;
import com.iko.iko.controller.board.dto.BoardRequest;
import com.iko.iko.controller.board.dto.BoardResponse;
import com.iko.iko.controller.coupon.dto.request.CouponRequestDto.InsertCouponRequest;
import com.iko.iko.controller.event.dto.EventRequest.AddEventRequest;
import com.iko.iko.controller.order.dto.request.OrderRequestDto.*;
import com.iko.iko.controller.order.dto.response.OrderResponseDto.*;
import com.iko.iko.controller.product.dto.ProductResponse;
import com.iko.iko.controller.product.dto.request.ProductRequest;
import com.iko.iko.service.board.facade.BoardFacade;
import com.iko.iko.service.coupon.facade.CouponFacade;
import com.iko.iko.service.event.facade.EventFacade;
import com.iko.iko.service.image.facade.ImageFacade;
import com.iko.iko.service.order.facade.OrderFacade;
import com.iko.iko.service.product.facade.ProductFacade;
import com.iko.iko.controller.product.dto.request.ProductRequest.ProductSaveRequest;
import com.iko.iko.service.productDetails.facade.ProductDetailsFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final ProductFacade productFacade;
    private final EventFacade eventFacade;
    private final CouponFacade couponFacade;
    private final OrderFacade orderFacade;

    private final ProductDetailsFacade productDetailsFacade;

    private final ImageFacade imageFacade;
    private final BoardFacade boardFacade;


    @PostMapping("/insertProduct")
    public ResponseEntity<Response<String>> insertProduct(
            @RequestBody @Valid ProductSaveRequest productSaveRequest
    ) {
        return ResponseEntity.ok(
                Response.of(
                        productFacade.saveProductService(productSaveRequest),
                        "?????? ?????? ??????"
                )
        );
    }

    @PostMapping("/insertEvent")
    public ResponseEntity<Response<String>> insertEvent(
            @RequestBody @Valid AddEventRequest addEventRequest
    ) {
        return ResponseEntity.ok(
                Response.of(
                        eventFacade.addEvent(addEventRequest),
                        "????????? ?????? ??????"
                )
        );
    }

    @PostMapping("/insertCoupon")
    public ResponseEntity<Response<Integer>> insertCoupon(
            @RequestBody @Valid InsertCouponRequest insertCouponRequest
    ) {
        return ResponseEntity.ok(
                Response.of(couponFacade.insertCoupon(insertCouponRequest),
                        "?????? ?????? ??????")
        );
    }

    @GetMapping("/allOrderInfo")
    public ResponseEntity<Response<List<GetAllOrderResponse>>> getAllOrderInfo() {
        return ResponseEntity.ok(
                Response.of(orderFacade.getAllOrderInfo(),
                        "?????? ?????? ?????? ??????")
        );
    }

    @GetMapping("/searchOrderById")
    public ResponseEntity<Response<List<GetProductAndDetailsInfoForAdminResponse>>> searchOrderById(
            @RequestParam(value = "orderId") Integer orderId
    ) {
        return ResponseEntity.ok(
                Response.of(orderFacade.searchOrderById(orderId),
                        "?????? ????????? ?????? ?????? ?????? ??????")
        );
    }

    @PutMapping("/updateOrderStatus")
    public ResponseEntity<Response<String>> updateOrderStatus(
            @RequestBody @Valid UpdateOrderStatusRequest updateOrderStatusRequest
    ) {
        return ResponseEntity.ok(
                Response.of(orderFacade.updateOrderStatus(updateOrderStatusRequest),
                        "?????? ?????? ?????? ??????")
        );
    }

    @GetMapping("/allProductInfo")
    public ResponseEntity<Response<List<ProductResponse.ProductInfoResponse>>> allProductInfo() {
        return ResponseEntity.ok(
                Response.of(productFacade.allProductInfo(),
                        "?????? ?????? ?????? ?????? ??????")
        );
    }


    @GetMapping("/searchDetailsById")
    public ResponseEntity<Response<ProductResponse.ProductDetailsInfoResponse>> searchDetailsById(
            @RequestParam(value = "productId") Integer productId
    ) {
        return ResponseEntity.ok(
                Response.of(productDetailsFacade.searchDetailsById(productId),
                        "?????? ?????? ?????? ?????? ??????")
        );
    }

    @GetMapping("/insertBannerImage")
    public ResponseEntity<Response<String>> insertBannerImage(
            @RequestParam(value = "imageUrl") String imageUrl
    ) {
        return ResponseEntity.ok(
                Response.of(
                        imageFacade.addBannerImage(imageUrl),
                        "??????????????? ????????????")
        );
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<Response<String>> updateProduct(
            @RequestBody @Valid ProductRequest.ProductUpdateRequest productUpdateRequest
    ) {
        return ResponseEntity.ok(
                Response.of(productFacade.updateProduct(productUpdateRequest),
                        "?????? ?????? ?????? ??????")
        );
    }

    @GetMapping("/stock")
    public ResponseEntity<Response<List<ProductResponse.stockListResponse>>> stockList(
            @RequestParam(value = "productId") Integer productId,
            @RequestParam(value = "color") String color,
            @RequestParam(value = "period") Integer period,
            @RequestParam(value = "graphicDiameter") Float graphicDiameter
    ) {
        return ResponseEntity.ok(
                Response.of(productFacade.stockList(productId, color, period, graphicDiameter),
                        "?????? ?????? ?????? ??????")
        );
    }

    @PostMapping("/insertBoard")
    public ResponseEntity<Response<String>> addBoard(
            @RequestBody @Valid BoardRequest.AddBoardRequest request
    ) {
        return ResponseEntity.ok(
                Response.of(boardFacade.addBoard(request),
                        "???????????? ?????? ??????"
                ));
    }

    @GetMapping("/boardMain")
    public ResponseEntity<Response<BoardResponse.BoardMainForAdminResponse>>
    getBoardMainForAdmin() {
        return ResponseEntity.ok(
                Response.of(boardFacade.getBoardMainForAdmin(),
                        "???????????? ?????? ???????????? ??????")
        );
    }

    @DeleteMapping("/deleteProduct")
    public ResponseEntity<Response<String>> deleteProduct(
            @RequestParam(value = "productId") Integer productId
    ) {
        return ResponseEntity.ok(
                Response.of(productFacade.deleteProduct(productId),
                        "?????? ?????? ??????")
        );
    }

    @PutMapping("/updateStock")
    public ResponseEntity<Response<String>> updateStock(
            @RequestBody @Valid ProductDetailsRequest.UpdateStockRequest updateStockRequest
    ) {
        return ResponseEntity.ok(
                Response.of(productDetailsFacade.updateStock(updateStockRequest),
                        "?????? ?????? ??????")
        );
    }

    @DeleteMapping("/deleteEvent")
    public ResponseEntity<Response<String>> deleteEvent(
            @RequestParam(value = "eventId") Integer eventId
    ) {
        return ResponseEntity.ok(
                Response.of(eventFacade.deleteEvent(eventId),
                        "????????? ?????? ??????")
        );
    }

}
