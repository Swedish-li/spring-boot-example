package com.lrs.boot.swagger2.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lrs.boot.swagger2.dto.PageQuery;
import com.lrs.boot.swagger2.dto.Person;
import com.lrs.boot.swagger2.service.PersonService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("persons")
public class PersonController {

	@Resource
	PersonService personService;

	@ApiResponse(message = "A list of Person", code = 200)
	@ApiOperation(value = "Gets some persons", notes = "Returns a list containing all persons")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageSize", defaultValue = "10", paramType = "query", dataType = "int", required = false),
			@ApiImplicitParam(name = "pageNo", defaultValue = "1", paramType = "query", dataType = "int", required = false)
	})
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Person>> query(PageQuery query) {

		return ResponseEntity.ok(personService.getAll());
	}

}
