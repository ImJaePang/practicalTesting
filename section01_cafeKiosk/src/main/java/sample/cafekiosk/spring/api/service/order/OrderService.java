package sample.cafekiosk.spring.api.service.order;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import sample.cafekiosk.spring.api.controller.order.request.OrderCreateRequest;
import sample.cafekiosk.spring.api.service.order.response.OrderResponse;
import sample.cafekiosk.spring.domain.order.Order;
import sample.cafekiosk.spring.domain.order.OrderRepository;
import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductRepository;
import sample.cafekiosk.spring.domain.product.ProductType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderResponse createOrder(OrderCreateRequest orderCreateRequest, LocalDateTime RegisteredDateTime) {
        List<String> productNumbers = orderCreateRequest.getProductNumbers();
        List<Product> products = findProductsBy(productNumbers);

        // 재고 차감 체크가 필요한 상품들 filter
        products.stream()
                .filter(product -> ProductType.containsStockType(product.getType()))
                .collect(Collectors.toList());
        // 재고 엔티티 조회
        // 상품별 counting
        // 재고 차감 시도


        Order order = Order.create(products, RegisteredDateTime);
        Order savedOrder = orderRepository.save(order);
        // Order
        return OrderResponse.of(savedOrder);
    }

    private @NonNull List<Product> findProductsBy(List<String> productNumbers) {
        List<Product> products = productRepository.findAllByProductNumberIn(productNumbers);
        Map<String, Product> productMap = products.stream()
                .collect(Collectors.toMap(Product::getProductNumber, p -> p));

        List<Product> duplicateProducts = productNumbers.stream()
                .map(productMap::get)
                .collect(Collectors.toList());
        return duplicateProducts;
    }


}
