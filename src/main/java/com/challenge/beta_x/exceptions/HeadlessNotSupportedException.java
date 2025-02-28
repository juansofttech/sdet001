package com.challenge.beta_x.exceptions;

public class HeadlessNotSupportedException extends IllegalStateException {

	public HeadlessNotSupportedException(String browser) {
		super(String.format("Headless not supported for %s browser", browser));
	}
}
