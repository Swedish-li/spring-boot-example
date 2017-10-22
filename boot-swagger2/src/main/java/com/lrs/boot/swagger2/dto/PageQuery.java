package com.lrs.boot.swagger2.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("page query param")
public class PageQuery {
	@ApiModelProperty(" page size")
	public int pageSize = 10;
	@ApiModelProperty("page no")
	public int pageNo = 1;

}
