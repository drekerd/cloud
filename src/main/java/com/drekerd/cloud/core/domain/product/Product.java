package com.drekerd.cloud.core.domain.product;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;

@Getter
@Entity(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private BigDecimal price;

	@Column(nullable = false)
	private String currency;

	@Column(nullable = false)
	private String origin;

	protected Product() {
	}

	// Temporary builder, replace with lombok, this one was just a case of study and understanding
	public static class ProductBuilder {
		private long id;
		private String name;
		private BigDecimal price;
		private String currency;
		private String origin;

		public ProductBuilder() {
		}

		public ProductBuilder withId(final long id) {
			this.id = id;
			return this;
		}

		public ProductBuilder withName(final String name) {
			this.name = name;
			return this;
		}

		public ProductBuilder withPrice(final BigDecimal price) {
			this.price = price;
			return this;
		}

		public ProductBuilder withCurrency(final String currency) {
			this.currency = currency;
			return this;
		}

		public ProductBuilder withOrigin(final String origin) {
			this.origin = origin;
			return this;
		}

		public Product build() {
			Product product = new Product();
			product.id = this.id;
			product.name = this.name;
			product.price = this.price;
			product.currency = this.currency;
			product.origin = this.origin;

			return product;
		}
	}
}
