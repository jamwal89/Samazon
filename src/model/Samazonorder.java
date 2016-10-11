package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


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
	
	
	@Temporal(TemporalType.DATE)
	private Date ondate;

	private String orderconfirmed;

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

	public Date getOndate() {
		return this.ondate;
	}

	public void setOndate(Date ondate) {
		this.ondate = ondate;
	}

	public String getOrderconfirmed() {
		return this.orderconfirmed;
	}

	public void setOrderconfirmed(String orderconfirmed) {
		this.orderconfirmed = orderconfirmed;
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