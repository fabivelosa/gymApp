package com.ait.gym.utils;

public enum CreditTypes {

	TREE_MONTHS(1, "Three months membership "), SIX_MONTHS(2, "Six months membership"),
	TWELVE_MONTHS(4, "Twelve months membership paid");

	private final int creditQtd;
	private final String value;

	private CreditTypes(int creditQtd, String value) {
		this.creditQtd = creditQtd;
		this.value = value;

	}

	public int getCreditQtd() {
		return this.creditQtd;
	}

	public String getValue() {
		return this.value;
	}

}