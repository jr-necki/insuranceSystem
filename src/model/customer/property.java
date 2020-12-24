package model.customer;

public class property {
	
	private int id;
	private int car;
	private int house;

	public property(){
	}
	
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id=id;
	}

	public int getCar() {
		return car;
	}

	public void setCar(int car) {
		this.car = car;
	}

	public int getHouse() {
		return house;
	}

	public void setHouse(int house) {
		this.house = house;
	}

}