package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_productos")
@Data
public class Producto {
	@Id
	private String id_prod;
	private String des_prod;
	private int stk_prod;
	private double pre_prod;
	private int idcategoria;
	private int est_prod;
	private int idproveedor;
		
	@ManyToOne
	@JoinColumn(name = "idcategoria", insertable = false,  updatable = false)
	private Categoria objCategoria;
	
	@ManyToOne
	@JoinColumn(name = "idproveedor", insertable = false,  updatable = false)
	private Proveedor objProveedor;

	public String getId_prod() {
		return id_prod;
	}

	public void setId_prod(String id_prod) {
		this.id_prod = id_prod;
	}

	public String getDes_prod() {
		return des_prod;
	}

	public void setDes_prod(String des_prod) {
		this.des_prod = des_prod;
	}

	public int getStk_prod() {
		return stk_prod;
	}

	public void setStk_prod(int stk_prod) {
		this.stk_prod = stk_prod;
	}

	public double getPre_prod() {
		return pre_prod;
	}

	public void setPre_prod(double pre_prod) {
		this.pre_prod = pre_prod;
	}

	public int getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public int getEst_prod() {
		return est_prod;
	}

	public void setEst_prod(int est_prod) {
		this.est_prod = est_prod;
	}

	public int getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}

	public Categoria getObjCategoria() {
		return objCategoria;
	}

	public void setObjCategoria(Categoria objCategoria) {
		this.objCategoria = objCategoria;
	}

	public Proveedor getObjProveedor() {
		return objProveedor;
	}

	public void setObjProveedor(Proveedor objProveedor) {
		this.objProveedor = objProveedor;
	}
	
}
