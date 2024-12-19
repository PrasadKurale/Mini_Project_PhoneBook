package in.ashokit.binding;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Table(name = "CITIZEN_PLANS_INFO")
@Entity
public class CitizenPlan {

	@Id
	@GeneratedValue
	private Integer cid;
	private String planName;
	private String planStatus;
	private String cname;
	private String cemail;
	private String gender;
	private Long phoneNumber;
	private Long ssn;

	public Integer getCid() {
		return cid;
	}

	public String getPlanName() {
		return planName;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public String getCname() {
		return cname;
	}

	public String getCemail() {
		return cemail;
	}

	public String getGender() {
		return gender;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

	public CitizenPlan(Integer cid, String planName, String planStatus, String cname, String cemail, String gender,
			Long phoneNumber, Long ssn) {
		super();
		this.cid = cid;
		this.planName = planName;
		this.planStatus = planStatus;
		this.cname = cname;
		this.cemail = cemail;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.ssn = ssn;
	}

	public CitizenPlan() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CitizenPlan [cid=" + cid + ", planName=" + planName + ", planStatus=" + planStatus + ", cname=" + cname
				+ ", cemail=" + cemail + ", gender=" + gender + ", phoneNumber=" + phoneNumber + ", ssn=" + ssn + "]";
	}

}
