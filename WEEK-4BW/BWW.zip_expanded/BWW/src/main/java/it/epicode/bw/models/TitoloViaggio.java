package it.epicode.bw.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
public abstract class TitoloViaggio {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(unique = true, name = "cod_univoco")
	protected String codUnivoco;

	protected boolean convalida = false;

	@Column(name = "data_emissione")
	protected LocalDate dataEmissione;
	@Column(name = "data_convalida")
	protected LocalDate dataConvalida = null;

	@ManyToOne
	protected PuntoVendita puntoVendita;

	@ManyToOne
	protected MezzoTrasporto mezzoVidimante;

	public TitoloViaggio(String codUnivoco, boolean convalida) {

		this.codUnivoco = codUnivoco;
		this.convalida = convalida;
	}

	public TitoloViaggio() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodUnivoco() {
		return codUnivoco;
	}

	public void setCodUnivoco(String codUnivoco) {
		this.codUnivoco = codUnivoco;
	}

	public boolean isConvalida() {
		return convalida;
	}

	public void setConvalida(boolean convalida) {
		this.convalida = convalida;
	}

	public LocalDate getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(LocalDate dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public LocalDate getDataConvalida() {
		return dataConvalida;
	}

	public void setDataConvalida(LocalDate dataConvalida) {
		this.dataConvalida = dataConvalida;
	}

	public PuntoVendita getPuntoVendita() {
		return puntoVendita;
	}

	public void setPuntoVendita(PuntoVendita puntoVendita) {
		this.puntoVendita = puntoVendita;
	}

	public MezzoTrasporto getMezzoVidimante() {
		return mezzoVidimante;
	}

	public void setMezzoVidimante(MezzoTrasporto mezzoVidimante) {
		this.mezzoVidimante = mezzoVidimante;
	}

}
