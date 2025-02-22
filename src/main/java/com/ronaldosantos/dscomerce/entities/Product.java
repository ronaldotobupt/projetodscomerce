package com.ronaldosantos.dscomerce.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String name;
	
	@Column(columnDefinition = "TEXT") //Definindo o campo para o fomato TEXT, para que aceite textos maiores
	private String description;
	private Double price;
	private String imgUrl;
	
	
	@ManyToMany //Relacionamento muitos para muitos
	@JoinTable(name = "tb_product_category",
						joinColumns = @JoinColumn(name = "product_id"),
						inverseJoinColumns = @JoinColumn(name = "category_id")) // Criando uma tabela de junção
	private Set<Category> categories = new HashSet<>(); //Instanciando uma lista do tipo Set, no relacionamento muitos para muitos não pode haver repetição de ID na lista
	
	@OneToMany(mappedBy = "id.product")
	private Set<OrderItem> items = new HashSet<>();
	
	public Product() {
		
	}

	public Product(Long id, String name, String description, Double price, String imgUrl) {
		Id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public Set<OrderItem> getItems() {
		return items;
	}
	
	public List<Order> getOrders() {
		return items.stream().map(x -> x.getOrder()).toList();
		}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(Id, other.Id);
	}
	
	

}
