package in.ashokit.binding;

import java.time.LocalDate;

public class SeachRequest {

	private String planeName;

	private String planStatus;

	private String gender;

	private LocalDate startDate;

	private LocalDate endDate;

	public String getPlaneName() {
		return planeName;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public SeachRequest(String planeName, String planStatus, String gender, LocalDate startDate, LocalDate endDate) {
		super();
		this.planeName = planeName;
		this.planStatus = planStatus;
		this.gender = gender;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public SeachRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SeachRequest [planeName=" + planeName + ", planStatus=" + planStatus + ", gender=" + gender
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	

}
