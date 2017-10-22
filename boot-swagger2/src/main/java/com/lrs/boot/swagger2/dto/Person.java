package com.lrs.boot.swagger2.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Person info", description = "desc person")
public class Person {
	@ApiModelProperty(required = true, notes = "all name")
	public String username;
	@ApiModelProperty(notes = "first name")
	public String firstName;
	@ApiModelProperty(notes = "last name")
	public String lastName;

}
