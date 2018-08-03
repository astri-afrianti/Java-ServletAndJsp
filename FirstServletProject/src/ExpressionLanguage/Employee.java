package ExpressionLanguage;

public class Employee implements IPerson {
	private String name;
	private int id;
	private Address address;
	private String role;

	public Employee() {
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String nm) {
		this.name = nm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString(){
		return "ID = " + id + ", Name = " + name + ", Address = " + address;
	}
}
