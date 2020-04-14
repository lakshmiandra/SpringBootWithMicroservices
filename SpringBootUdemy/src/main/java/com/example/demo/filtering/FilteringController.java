package com.example.demo.filtering;

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

	// send only filed1 and field2
/*	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("value1","Value2","Value3");
	}*/
	
	// send only filed1 and field2
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		
		SomeBean someBean = new SomeBean("value1","Value2","Value3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("feild1","feild2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mjValue = new MappingJacksonValue(someBean);
		mjValue.setFilters(filters);
		
		return mjValue;
	}
	
	
	// Send only field 2 and filed3
/*	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveSomeBeanList() {
		return (Arrays.asList(new SomeBean("value1","Value2","Value3"),
				new SomeBean("field4", "feild5", "feild6")));
	}*/
	
	// 2nad 3
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveSomeBeanList() {
		
		List<SomeBean> listOfBean = (Arrays.asList(new SomeBean("value1","Value2","Value3"),
				new SomeBean("value1", "value2", "value3")));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("feild2","feild3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mjValue = new MappingJacksonValue(listOfBean);
		mjValue.setFilters(filters);
		
		return mjValue;
	}
}
