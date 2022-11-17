package com.sportmanagemententity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "players_detail")
public class PlayerDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// variables
	@Column(name = "id")
	private int id;

	@Column(name = "address")
	private String address;

	@Column(name = "category")
	private String category;

	@OneToOne(mappedBy = "playerDetail", cascade = CascadeType.ALL)
	private Player player;

	public PlayerDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayerDetail(String address, String category) {
		super();
		this.address = address;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "PlayerDetail [id=" + id + ", address=" + address + ", category=" + category + ", player=" + player
				+ "]";
	}

}
