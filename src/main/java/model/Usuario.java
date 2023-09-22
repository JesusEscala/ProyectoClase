package model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name = "tb_usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {

	//atributos
	
	@Id
	private int cod_usua;
	private String nom_usua;
	private String ape_usua;
	private String usr_usua;
	private String cla_usua;
	private String fna_usua;
	private int idtipo;
	private int est_usua;
	
	@ManyToOne
	@JoinColumn(name = "idtipo", insertable = false, updatable = false)
	// GUARDAR TODA LA INFORMACION
	private Tipo objTipo;

	public int getCod_usua() {
		return cod_usua;
	}

	public void setCod_usua(int cod_usua) {
		this.cod_usua = cod_usua;
	}

	public String getNom_usua() {
		return nom_usua;
	}

	public void setNom_usua(String nom_usua) {
		this.nom_usua = nom_usua;
	}

	public String getApe_usua() {
		return ape_usua;
	}

	public void setApe_usua(String ape_usua) {
		this.ape_usua = ape_usua;
	}

	public String getUsr_usua() {
		return usr_usua;
	}

	public void setUsr_usua(String usr_usua) {
		this.usr_usua = usr_usua;
	}

	public String getCla_usua() {
		return cla_usua;
	}

	public void setCla_usua(String cla_usua) {
		this.cla_usua = cla_usua;
	}

	public String getFna_usua() {
		return fna_usua;
	}

	public void setFna_usua(String fna_usua) {
		this.fna_usua = fna_usua;
	}

	public int getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}

	public int getEst_usua() {
		return est_usua;
	}

	public void setEst_usua(int est_usua) {
		this.est_usua = est_usua;
	}

	public Tipo getObjTipo() {
		return objTipo;
	}

	public void setObjTipo(Tipo objTipo) {
		this.objTipo = objTipo;
	}
	
	
}
