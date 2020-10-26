package com.prashant.test.webservices.restwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;


@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue getSomeBean() {
		SomeBean someBean=new SomeBean("Value1","Value2","Value3");

		//field1,field2
		SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping=new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		return mapping;
	}

	
	//filed1
	@GetMapping("/filtering-list")
	public MappingJacksonValue getListSomeBean() {
		List<SomeBean> list=  Arrays.asList(new SomeBean("Value1","Value2","Value3"),
				new SomeBean("Value11","Value21","Value31"));
		SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping=new MappingJacksonValue(list);
		mapping.setFilters(filters);
		return mapping;
		
		
	}

}
