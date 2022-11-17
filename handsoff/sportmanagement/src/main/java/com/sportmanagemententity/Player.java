package com.sportmanagemententity;

import jakarta.persistence.CascadeType;
//id,player first name,player last name,age,address,category
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity

@Table(name = " playerinfo ")
//POJO class
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id") // it will be disply in database table
	private int id;

	@Column(name = "player_First_Name")
	private String playerFirstName;

	@Column(name = "player_Last_Name")
	private String playerLastName;

	@Column(name = "player_age")
	private int playerage;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "player_detail_id")
	private PlayerDetail playerDetail;

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(String playerFirstName, String playerLastName, int playerage) {
		super();

		this.playerFirstName = playerFirstName;
		this.playerLastName = playerLastName;
		this.playerage = playerage;

	}

	public String getPlayerFirstName() {
		return playerFirstName;
	}

	public void setPlayerFirstName(String playerFirstName) {
		this.playerFirstName = playerFirstName;
	}

	public String getPlayerLastName() {
		return playerLastName;
	}

	public void setPlayerLastName(String playerLastName) {
		this.playerLastName = playerLastName;
	}

	public int getPlayerage() {
		return playerage;
	}

	public void setPlayerage(int playerage) {
		this.playerage = playerage;
	}

	public PlayerDetail getPlayerDetail() {
		return playerDetail;
	}

	public void setPlayerDetail(PlayerDetail playerDetail) {
		this.playerDetail = playerDetail;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", playerFirstName=" + playerFirstName + ", playerLastName=" + playerLastName
				+ ", playerage=" + playerage + ", playerDetail=" + playerDetail + "]";
	}

}
