package com.bnppfortis.channels.controller;

import com.bnppfortis.channels.constants.CommonConstants;
import com.bnppfortis.channels.models.LeapYearResponse;
import com.bnppfortis.channels.service.LeapYearService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * This is the RestController class where we will defining our Rest API.
 * <p>
 * Created by Dev2018039 on 12/22/2018.
 */
@RestController
@RequestMapping(path = "/channels")
@Api(tags = "channels")
public class LeapYearController {


    @Autowired
    LeapYearService leapYearService;

    private static final Logger logger = LoggerFactory.getLogger(LeapYearController.class);

    /**
     * This method is used to validate Whether the given year is valid and should be prior
     * to 1582 and less than 8000.
     *
     * @param year- Integer
     * @return String - returns a string indicating leap , not a leap year or not a valid year.
     */
    @GetMapping(path = "/validate/leap-year/{year}")
    @ApiOperation(value = "This API is used to validate whether the given year is LeapYear or not as a plain text",
            response = String.class,
            produces = MediaType.TEXT_PLAIN_VALUE,
            consumes = MediaType.TEXT_PLAIN_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = String.class),
            @ApiResponse(code = 404, message = "Requested URI Not Found"),
            @ApiResponse(code = 400, message = "Bad Request Params")
    })
    public String validateLeapYear(@PathVariable int year) {
        logger.debug("Entered validateLeapYear path variable");
        String result = CommonConstants.YEAR_SHOULD_BE_BETWEEN_1582_TO_8000;
        if (year > CommonConstants.LEAST_VALUE && year <= CommonConstants.EIGHT_THOUSAND) {
            result = leapYearService.isLeapYear(year) ? year + " is a Leap Year" : year + " is not a Leap Year";
        }
        logger.debug("Exiting validateLeapYear path variable");
        logger.debug(result);
        return result;
    }


    /**
     * This method is used to validate Whether the given year present in json is valid and should be greater
     * than zero and less than 8000.
     *
     * @param year - LeapYearRequest
     * @return leapYearResponse - Returns LeapYearResponse
     */
    @GetMapping(path = "/validate/leap-year")
    @ApiOperation(value = "This API is used to calculate whether the given year is LeapYear or not and produces " +
            "the output in json",
            response = LeapYearResponse.class, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.TEXT_PLAIN_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = LeapYearResponse.class),
            @ApiResponse(code = 404, message = "Requested URI Not Found"),
            @ApiResponse(code = 400, message = "Bad Request Params")
    })
    public LeapYearResponse validateTheLeapYear(@RequestParam int year) {
        logger.debug("Entered validateTheLeapYear Request Param");
        LeapYearResponse leapYearResponse = new LeapYearResponse();
        leapYearResponse.setYear(year);
        if (year > CommonConstants.LEAST_VALUE && year <= CommonConstants.EIGHT_THOUSAND) {
            leapYearResponse.setResult(leapYearService.isLeapYear(year)
                    ? year + " is a Leap Year"
                    : year + " is not a Leap Year");
        } else {
            leapYearResponse.setResult(CommonConstants.YEAR_SHOULD_BE_BETWEEN_1582_TO_8000);
        }
        logger.debug("Exiting validateTheLeapYear path variable");
        return leapYearResponse;
    }

}
