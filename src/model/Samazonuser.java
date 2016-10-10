package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SAMAZONUSER database table.
 * 
 */
@Entity
@NamedQuery(name="Samazonuser.findAll", query="SELECT s FROM Samazonuser s")
public class Samazonuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userid;

	private String useremail;

	private String username;

	private String userpassword;

	//bi-directional many-to-one association to Samazonorder
	@OneToMany(mappedBy="samazonuser")
	private List<Samazonorder> samazonorders;

	public Samazonuser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUseremail() {
		return this.useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return this.userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public List<Samazonorder> getSamazonorders() {
		return this.samazonorders;
	}

	public void setSamazonorders(List<Samazonorder> samazonorders) {
		this.samazonorders = samazonorders;
	}

	public Samazonorder addSamazonorder(Samazonorder samazonorder) {
		getSamazonorders().add(samazonorder);
		samazonorder.setSamazonuser(this);

		return samazonorder;
	}

	public Samazonorder removeSamazonorder(Samazonorder samazonorder) {
		getSamazonorders().remove(samazonorder);
		samazonorder.setSamazonuser(null);

		return samazonorder;
	}

}