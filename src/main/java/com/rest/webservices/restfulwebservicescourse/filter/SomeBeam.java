package com.rest.webservices.restfulwebservicescourse.filter;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonFilter("someFilter")
public class SomeBeam {

    private String field1;

    @JsonIgnore
    private String field2;

    private String field3;
    public SomeBeam(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }
    @Override
    public String toString() {
        return "SomeBeam [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
    }
    public String getField1() {
        return field1;
    }
    public String getField2() {
        return field2;
    }
    public String getField3() {
        return field3;
    }
    
}
