package com.bnppfortis.channels.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the RestController class where we will defining our Rest API.
 * <p>
 * Created by Dev2018039 on 12/22/2018.
 */
@RestController
@RequestMapping(path = "/channels")
public class LeapYearController {


    /**
     * This method is used to validate Whether the given year is valid and should be prior
     * to 1582 and less than 8000.
     *
     * @param year- Integer
     * @return String - returns a string indicating leap , not a leap year or not a valid year.
     */
    @GetMapping(path = "/validate/leap-year/{year}")
    public String validateLeapYear(@PathVariable int year) {
        return "Year should be between 1582 to 8000";
    }


}
