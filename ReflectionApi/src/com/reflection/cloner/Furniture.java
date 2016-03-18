package com.reflection.cloner;

public class Furniture {

	public double price;

	protected char mark;

	private double test;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public char getMark() {
		return mark;
	}

	public void setMark(char mark) {
		this.mark = mark;
	}

	public double getTest() {
		return test;
	}

	public void setTest(double test) {
		this.test = test;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mark;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(test);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Furniture other = (Furniture) obj;
		if (mark != other.mark)
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (Double.doubleToLongBits(test) != Double
				.doubleToLongBits(other.test))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Furniture [price=" + price + ", mark=" + mark + ", test="
				+ test + ", hashCode=" + this.hashCode() + "]";
	}
}
