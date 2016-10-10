package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SAMAZONORDERS database table.
 * 
 */
@Entity
@Table(name="SAMAZONORDERS")
@NamedQuery(name="Samazonorder.findAll", query="SELECT s FROM Samazonorder s")
public class Samazonorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long orderid;

	private String orderplace;

	private String productdetails;

	private String productname;

	private double productprice;

	//bi-directional many-to-one association to Samazonproduct
	@ManyToOne
	@JoinColumn(name="PRODUCTID")
	private Samazonproduct samazonproduct;

	//bi-directional many-to-one association to Samazonuser
	@ManyToOne
	@JoinColumn(name="USERID")
	private Samazonuser samazonuser;

	public Samazonorder() {
	}

	public long getOrderid() {
		return this.orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public String getOrderplace() {
		return this.orderplace;
	}

	public void setOrderplace(String orderplace) {
		this.orderplace = orderplace;
	}

	public String getProductdetails() {
		return this.productdetails;
	}

	public void setProductdetails(String productdetails) {
		this.productdetails = productdetails;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getProductprice() {
		return this.productprice;
	}

	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}

	public Samazonproduct getSamazonproduct() {
		return this.samazonproduct;
	}

	public void setSamazonproduct(Samazonproduct samazonproduct) {
		this.samazonproduct = samazonproduct;
	}

	public Samazonuser getSamazonuser() {
		return this.samazonuser;
	}

	public void setSamazonuser(Samazonuser samazonuser) {
		this.samazonuser = samazonuser;
	}

}