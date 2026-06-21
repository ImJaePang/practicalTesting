package sample.cafekiosk.unit;

import org.junit.jupiter.api.Test;
import sample.cafekiosk.unit.beverages.Americano;
import sample.cafekiosk.unit.beverages.Latte;
import sample.cafekiosk.unit.order.Order;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CafeKioskTest {

    @Test
    void add_manual_test() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add((new Americano()));

        System.out.println(">>> 담긴 음료 수 : " + cafeKiosk.getBeverages().size());
        System.out.println(">>> 담긴 음료 : " + cafeKiosk.getBeverages().get(0).getName());
    }

    @Test
    void add() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add((new Americano()));

        assertThat(cafeKiosk.getBeverages().size()).isEqualTo(1);
        assertThat(cafeKiosk.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @Test
    void addSeveralBeverages() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add((new Americano()), 2);

        assertThat(cafeKiosk.getBeverages().size()).isEqualTo(2);
        assertThat(cafeKiosk.getBeverages().get(0).getName()).isEqualTo("아메리카노");
        assertThat(cafeKiosk.getBeverages().get(1).getName()).isEqualTo("아메리카노");
    }
    @Test
    void addZeroBeverages() { // 경계값에 대한 테스트
        CafeKiosk cafeKiosk = new CafeKiosk();
//        cafeKiosk.add((new Americano()), 0);

        assertThatThrownBy(()-> cafeKiosk.add(new Americano(),0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음료는 1잔 이상 주문하실 수 있습니다.")
        ;
    }

    @Test
    void remove() {

        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add((new Americano()));

        assertThat(cafeKiosk.getBeverages().size()).isEqualTo(1);
        assertThat(cafeKiosk.getBeverages().get(0).getName()).isEqualTo("아메리카노");

        cafeKiosk.remove(cafeKiosk.getBeverages().get(0));
        assertThat(cafeKiosk.getBeverages()).isEmpty();


    }

    @Test
    void clear() {

        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add((new Americano()));
        cafeKiosk.add((new Latte()));

        assertThat(cafeKiosk.getBeverages().size()).isEqualTo(2);
        assertThat(cafeKiosk.getBeverages().get(0).getName()).isEqualTo("아메리카노");

        cafeKiosk.clear();
        assertThat(cafeKiosk.getBeverages()).isEmpty();
    }

    @Test
    void createOrder() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add((new Americano()));

        Order order = cafeKiosk.CreateOrder();

        assertThat(order.getBeverages().size()).isEqualTo(1);
        assertThat(order.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }
    @Test
    void createOrderWithCurrentTime() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add((new Americano()));

        Order order = cafeKiosk.CreateOrder(LocalDateTime.of(2026, 6, 21, 10, 0));

        assertThat(order.getBeverages().size()).isEqualTo(1);
        assertThat(order.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @Test
    void createOrderOutsiteOpenTime() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add((new Americano()));

//        Order order = cafeKiosk.CreateOrder(LocalDateTime.of(2026, 6, 21, 9, 59));
        assertThatThrownBy(() -> cafeKiosk.CreateOrder(LocalDateTime.of(2026, 6, 21, 9, 59)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("주문 시간이 아닙니다. 관리자에게 문의하세요.");

    }
}