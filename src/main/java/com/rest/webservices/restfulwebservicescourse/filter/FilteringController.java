package com.rest.webservices.restfulwebservicescourse.filter;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
    
    @GetMapping(path = "/filtering")
    public SomeBeam someBean(){
        return new SomeBeam("value1","value2","value3");
    }

    @GetMapping(path = "/filtering-dynamic")
    public MappingJacksonValue dynamicFilter(){

        SomeBeam b = new SomeBeam("value1","value2","value3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(b);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
        FilterProvider filters = new SimpleFilterProvider().addFilter("someFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}
