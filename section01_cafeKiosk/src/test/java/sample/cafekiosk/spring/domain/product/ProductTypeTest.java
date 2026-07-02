package sample.cafekiosk.spring.domain.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductTypeTest {

    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다. 베이커리")
    @Test
    void containsStockType2() {
        // given
//        ProductType givenType = ProductType.HANDMADE;
        ProductType givenType = ProductType.BAKERY;

        // when
        boolean result = ProductType.containsStockType(givenType);

        // then
//        assertThat(result).isFalse();
        assertThat(result).isTrue();

    }

    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다. 핸드메이드")
    @Test
    void containsStockType1() {
        // given
        ProductType givenType = ProductType.HANDMADE;
//        ProductType givenType = ProductType.BAKERY;
//
        // when
        boolean result = ProductType.containsStockType(givenType);

        // then
        assertThat(result).isFalse();
//        assertThat(result).isTrue();

    }
}