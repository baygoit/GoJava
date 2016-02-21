package com.kickstarter.beanVO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class UserVo {
	@Size(min = 3, max = 25)
	@Pattern(regexp = "^[A-Za-z0-9]*$")
	@NotEmpty
	@NotNull
	private String name;

	@NotEmpty
	@NotNull
	@Size(min = 3, max = 25)
    @Pattern(regexp = "^[A-Za-z0-9]*$")
	private String password;

	public UserVo() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
