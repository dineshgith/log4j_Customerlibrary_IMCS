package com.log4j.log4jcustomerhibernate.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Integer orderId;

	@Temporal(TemporalType.DATE)
	@Column(name = "invoice_creation_date")
	private Date invoiceCreationDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "delivery_due_date")
	private Date deliveryDueDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "payment_due_date")
	private Date paymentDueDate;

	@Column(name = "custom_message")
	private String customMessage;

	@OneToMany(mappedBy = "orderId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<OrderProducts> orderProducts;

	// @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Integer customerId;

}
