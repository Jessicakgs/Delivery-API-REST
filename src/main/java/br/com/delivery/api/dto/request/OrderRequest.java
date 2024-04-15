package br.com.delivery.api.dto.request;

import java.util.List;

public record OrderRequest(Integer customerId, List<AssocProductOrderRequest> products, String Address) {
}
