package com.log4j.log4jcustomerhibernate.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "order_products")
public class OrderProducts {
	@Id
	@Column(name = "order_product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderProductId;

	//@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Integer orderId;

	//@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Integer productId;

	@Column(name = "quantity")
	private Integer quantity;
}
