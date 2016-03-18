package com.reflection.cloner;

import java.util.Arrays;
import java.util.List;

public class Table extends Furniture {

	public static final int MODEL_NUMBER = 1;
	
	public List<String> naming;
	public Chair chair;

	public int[] legsNumber;
	public String str;

	private double width;
	private double height;

	public int[] getLegsNumber() {
		return legsNumber;
	}

	public void setLegsNumber(int[] legsNumber) {
		this.legsNumber = legsNumber;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((chair == null) ? 0 : chair.hashCode());
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Arrays.hashCode(legsNumber);
		result = prime * result + ((naming == null) ? 0 : naming.hashCode());
		result = prime * result + ((str == null) ? 0 : str.hashCode());
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Table other = (Table) obj;
		if (chair == null) {
			if (other.chair != null)
				return false;
		} else if (!chair.equals(other.chair))
			return false;
		if (Double.doubleToLongBits(height) != Double
				.doubleToLongBits(other.height))
			return false;
		if (!Arrays.equals(legsNumber, other.legsNumber))
			return false;
		if (naming == null) {
			if (other.naming != null)
				return false;
		} else if (!naming.equals(other.naming))
			return false;
		if (str == null) {
			if (other.str != null)
				return false;
		} else if (!str.equals(other.str))
			return false;
		if (Double.doubleToLongBits(width) != Double
				.doubleToLongBits(other.width))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Table [naming=" + naming + ", chair=" + chair + ", legsNumber="
				+ Arrays.toString(legsNumber) + ", str=" + str + ", width="
				+ width + ", height=" + height + ", price=" + price + ", mark="
				+ mark + ", hashCode()=" + hashCode() + "]";
	}
}
