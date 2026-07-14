package sample.cafekiosk.spring.api.service.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.cafekiosk.spring.domain.order.Order;
import sample.cafekiosk.spring.domain.order.OrderRepository;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderStatisticsService {

    private final OrderRepository orderRepository;

    public void sendOrderStatiscticsMail(LocalDate orderDate, String email){
        // 해당 일자에 결제완료된 주문들을 가져와서
        List<Order> orders = orderRepository.findOrdersBy(
                //

        );

        // 총 매출 합게를 계산하고

        // 메일 전송

    }

}
