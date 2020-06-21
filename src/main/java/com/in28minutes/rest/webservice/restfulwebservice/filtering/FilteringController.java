package com.in28minutes.rest.webservice.restfulwebservice.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public Somebean RetrieveSomebean(){
        return new Somebean("value1","value2","value3");
    }
    @GetMapping("/filtering-list")
    public List<Somebean> RetrieveListSomebean(){
        return Arrays.asList (new Somebean("value1","value2","value3"),new Somebean("value12","value22","value32"));
    }
    //dynamic filtrering
    @GetMapping("/filtering-dynamic")
    public MappingJacksonValue RetrieveSomebeanDynamic(){
        Somebean somebean = new Somebean("value1","value2","value3");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter );
        MappingJacksonValue mapping = new MappingJacksonValue(somebean);
        mapping.setFilters(filters);
        return mapping;
    }
    @GetMapping("/filtering-list-dynamic")
    public List<Somebean> RetrieveListSomebeanDynamic(){
        return Arrays.asList (new Somebean("value1","value2","value3"),new Somebean("value12","value22","value32"));
    }
}
