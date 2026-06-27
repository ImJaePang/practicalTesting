package sample.cafekiosk.spring.api.controller.order.request;


import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class OrderCreateRequest {

    private List<String> productNumbers;
}
