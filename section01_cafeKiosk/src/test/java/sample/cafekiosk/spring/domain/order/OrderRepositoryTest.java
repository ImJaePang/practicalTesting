package sample.cafekiosk.spring.domain.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductSellingStatus;
import sample.cafekiosk.spring.domain.product.ProductType;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {

    @DisplayName("조건에 맞는 주문 정보를 가져온다. - 시작일자, 끝일자, 주문상태")
    @Test
    void test() {
        // given
        Product product1 = Product.builder()
                .type(ProductType.HANDMADE)
                .sellingStatus(ProductSellingStatus.SELLING)
                .name("아메아메리카노")
                .price(3000)
                .build();
        Order.create(List.of(product1), LocalDateTime.now());

        // when


        // then

    }
}