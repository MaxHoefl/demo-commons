package com.example.demo.resource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="items")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Item
{
	@Id
	@GenericGenerator(name="itemIdGen" , strategy="increment")
	@GeneratedValue(generator="itemIdGen")
    @Column(name = "itemid", nullable=false)
    private long id;
	
	@Column(name="itemname")
	private String itemName;

//    @ManyToOne
//    @JoinColumn(name = "cartid", nullable=false)
//    @JsonBackReference
//    private Cart cart;
	@Column(name="cartid")
	private Long cartId;
	
	
    public Item() {
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

//	public Cart getCart() {
//		return cart;
//	}
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}
	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	

	@Override
	public String toString() {
		return "Item [item_id=" + id + ", itemName=" + itemName +"]";
	}
//	@Override
//	public String toString() {
//		return "Item [item_id=" + id + ", itemName=" + itemName + "]";
//	}
}
