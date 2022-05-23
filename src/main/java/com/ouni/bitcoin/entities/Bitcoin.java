package com.ouni.bitcoin.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bitcoin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idBitcoin;
	private String BitcoinName;
	private Double BitcoinPrice;
	
	@JsonIgnore
	@OneToMany(mappedBy = "bitcoin")
	private List<Owners> owners;

	public long getIdBitcoin() {
		return idBitcoin;
	}

	public void setIdBitcoin(long idBitcoin) {
		this.idBitcoin = idBitcoin;
	}

	public String getBitcoinName() {
		return BitcoinName;
	}

	public void setBitcoinName(String bitcoinName) {
		BitcoinName = bitcoinName;
	}

	public Double getBitcoinPrice() {
		return BitcoinPrice;
	}

	public void setBitcoinPrice(Double bitcoinPrice) {
		BitcoinPrice = bitcoinPrice;
	}

	public List<Owners> getOwners() {
		return owners;
	}

	public void setOwners(List<Owners> owners) {
		this.owners = owners;
	}

	
	@Override
	public String toString() {
		return "Bitcoin [idBitcoin=" + idBitcoin + ", BitcoinName=" + BitcoinName + ", BitcoinPrice=" + BitcoinPrice
				+ ", owners=" + owners + "]";
	}
	
	
}
