package com.project.consorcio.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the tb_laboratorio database table.
 * 
 */
@Entity
@Table(name="tb_tipo_medicamento")
@NamedQuery(name="TipoMedicamento.findAll", query="SELECT l FROM TipoMedicamento l")
public class TipoMedicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_tipo")
	private int codTipo;

	@Column(name="nom_tipo")
	private String nomTipo;

	
	
	//bi-directional many-to-one association to Medicamento
	@OneToMany(mappedBy="tbTipoMedicamento")
	//omitir el JSON del atributo "tbMedicamentos"
	@JsonIgnore
	private List<Medicamento> tbMedicamentos;

	public TipoMedicamento() {
	}

	public int getCodTipo() {
		return this.codTipo;
	}

	public void setCodTipo(int codTipo) {
		this.codTipo = codTipo;
	}

	
	public String getNomTipo() {
		return this.nomTipo;
	}

	public void setNomTipo(String nomTipo) {
		this.nomTipo = nomTipo;
	}

	public List<Medicamento> getTbMedicamentos() {
		return this.tbMedicamentos;
	}

	public void setTbMedicamentos(List<Medicamento> tbMedicamentos) {
		this.tbMedicamentos = tbMedicamentos;
	}

	public Medicamento addTbMedicamento(Medicamento tbMedicamento) {
		getTbMedicamentos().add(tbMedicamento);
		tbMedicamento.setTbTipoMedicamento(this);

		return tbMedicamento;
	}

	public Medicamento removeTbMedicamento(Medicamento tbMedicamento) {
		getTbMedicamentos().remove(tbMedicamento);
		tbMedicamento.setTbTipoMedicamento(null);

		return tbMedicamento;
	}

}