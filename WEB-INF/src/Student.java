
public class Student{

	private int sid;
	private String name;
	private String address;
	private String phoneNo;
	private String year;
	private String major;
	private String email;
	private String dOB;
	private String gender;
	private String fatherName;
	private String nrc;

	public Student(int sid, String name, String address, String phoneNo, String year, String major, String email,
			String dOB, String gender, String fatherName, String nrc) {
		super();
		this.sid = sid;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.year = year;
		this.major = major;
		this.email = email;
		this.dOB = dOB;
		this.gender = gender;
		this.fatherName = fatherName;
		this.nrc = nrc;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getdOB() {
		return dOB;
	}

	public void setdOB(String dOB) {
		this.dOB = dOB;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}






}
