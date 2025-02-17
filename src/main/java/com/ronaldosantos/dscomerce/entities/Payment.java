package com.ronaldosantos.dscomerce.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_payment")
public class Payment {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long Id;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE") //Anotação para salvar no formato UTC no banco
	public Instant moment;
	
	
	@OneToOne //Anotação relação 1 para 1 na classe dependente
	@MapsId //Anotação relação 1 para 1 na classe dependente
	public Order order;
	
	public Payment() {
		
	}

	public Payment(Long id, Instant moment, Order order) {
		Id = id;
		this.moment = moment;
		this.order = order;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	

}
