package core;

public class Customer {
	public String name = "";
	public String streetAddress ="";
	public String city = "";
	public String state = "";
	public String zip = "";
	public int age = 0;
	
	public static void displayAddress(){
		Customer class1 = new Customer();
		Customer class2 = new Customer();
		String name = "";
		String streetAddress ="";
		String city = "";
		String state = "";
		String zip = "";
		int age = 0;
		
		class1.setName(name);
		class1.setAge(age);
		class1.setCity(city);
		class1.setState(state);
		class1.setStreetAddress(streetAddress);
		class1.setZip(zip);
		
		String address = streetAddress +""+ city +""+ state +""+ zip;
		System.out.println(address);
		class2.displayAddressLabel(address);
		
		
		
	}
	public static void displayAddressLabel(String address){
		Customer class3 = new Customer ();
		String myName = class3.getName();
		String addressLabel = (myName + address );
		System.out.println(addressLabel);
		
		
	}


	public Customer (){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	


}// endl class

