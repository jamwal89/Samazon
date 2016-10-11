package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SAMAZONPRODUCTS database table.
 * 
 */
@Entity
@Table(name="SAMAZONPRODUCTS")
@NamedQuery(name="Samazonproduct.findAll", query="SELECT s FROM Samazonproduct s")
public class Samazonproduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long productid;

	private String image;

	private String productdetails;

	private String productname;

	private double productprice;

	//bi-directional many-to-one association to Samazonorder
	@OneToMany(mappedBy="samazonproduct")
	private List<Samazonorder> samazonorders;

	public Samazonproduct() {
	}

	public long getProductid() {
		return this.productid;
	}

	public void setProductid(long productid) {
		this.productid = productid;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public List<Samazonorder> getSamazonorders() {
		return this.samazonorders;
	}

	public void setSamazonorders(List<Samazonorder> samazonorders) {
		this.samazonorders = samazonorders;
	}

	public Samazonorder addSamazonorder(Samazonorder samazonorder) {
		getSamazonorders().add(samazonorder);
		samazonorder.setSamazonproduct(this);

		return samazonorder;
	}

	public Samazonorder removeSamazonorder(Samazonorder samazonorder) {
		getSamazonorders().remove(samazonorder);
		samazonorder.setSamazonproduct(null);

		return samazonorder;
	}

}