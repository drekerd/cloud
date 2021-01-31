package com.drekerd.cloud.entrypoint.response;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductDTO {
	private final long id;
	private final String name;
	private final BigDecimal price;
	private final String currency;
	private final String origin;
}
