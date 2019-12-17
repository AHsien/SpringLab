package com.darren;

public class Address2 {

	private String addressLine1;
	private String city;
	private String state;
	private String country;

	public Address2() {

	}

	public Address2(String addressLine1, String city, String state, String country) {
		super();
		this.addressLine1 = addressLine1;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	@Override
	public String toString() {
		return addressLine1 + " " + city + " " + state + " " + country;
	}
}
