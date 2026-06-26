package sample.cafekiosk.spring.api.service.order.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import sample.cafekiosk.spring.api.service.product.response.ProductResponse;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class OrderResponse {
    private Long id;

    private int totalPrice;

    private LocalDate registeredDateTime;

    private List<ProductResponse> Products;
}
