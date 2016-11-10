package it.alfasoft.andrea.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.Embeddable;


@Embeddable
@ManagedBean(name="prod", eager=true)
public class Prodotto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nomeProdotto;
	private double prezzo;
	
	public Prodotto() {
	}

	public Prodotto(String nomeProdotto, double prezzo) {
		this.nomeProdotto = nomeProdotto;
		this.prezzo = prezzo;
	}

	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
