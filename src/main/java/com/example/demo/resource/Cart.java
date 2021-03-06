package com.example.demo.resource;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="carts")
public class Cart 
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cartid", nullable=false)
    private long id;
	
//	@Column(name="items")
//    @OneToMany(mappedBy = "cart")
//	@JsonManagedReference
//    private Set<Item> items;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="cartid", referencedColumnName="cartid")
	private Set<Item> items;

    public Cart() {}
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

	@Override
	public String toString() {
		return "Cart [cart_id=" + id + ", items=" + items + "]";
	}
}
