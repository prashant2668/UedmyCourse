package com.prashant.test.webservices.restwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {

	//1)Normal way
	@GetMapping("v1/person")
	public PersonV1 getPersonv1() {
		return new PersonV1("Prashant Mahale");


	}

	@GetMapping("v2/person")
	public Person2 getPersonV2() {
		return new Person2(new Name("Prashant", "Mahale"));


	}

	//2)using param--  http://localhost:8080/person/param?version1
	@GetMapping(value = "/person/param",params = "version1")
	public PersonV1 paramV1() {
		return new PersonV1("Prashant Mahale");


	}

	@GetMapping(value = "/person/param",params = "version2")
	public Person2 paramV2() {
		return new Person2(new Name("Prashant", "Mahale"));


	}

	//Using header
	@GetMapping(value = "/person/header",headers = "X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Prashant Mahale");


	}

	@GetMapping(value = "/person/header",headers  = "X-API-VERSION=2")
	public Person2 headerV2() {
		return new Person2(new Name("Prashant", "Mahale"));
	}

	
	//Using produces
	@GetMapping(value = "/person/produce",produces ="application/vnd.company.app-v1+json")
	public PersonV1 produceV1() {
		return new PersonV1("Prashant Mahale");


	}

	@GetMapping(value = "/person/produce",produces ="application/vnd.company.app-v2+json")
	public Person2 produceV2() {
		return new Person2(new Name("Prashant", "Mahale"));
	}
	
}
