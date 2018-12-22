package com.bnppfortis.channels.controller;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * This is the Class where will be defining the test for LeapYearController.
 *
 * <p>
 * Created by Dev2018039 on 12/23/2018.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LeapYearControllerTest extends TestCase {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext context;



    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    /**
     *
     * This method is used to test ValidateLeapYear Returns 400 when null year is not passed.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsBadRequestForNullYearsPassed() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/null" ))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     *
     * This method is used to test ValidateLeapYear Returns 400
     * when Some random String is passed as year.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsBadRequestForStringYearsPassed() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/string" ))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     *
     * This method is used to test ValidateLeapYear Returns 404
     * when Some random year passed.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsNotFoundForWrongURIAccessed() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-years/1582" ))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    /**
     *
     * This method is used to test ValidateLeapYear Returns Not a Valid Year for year 0.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsNotAValidYear() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/0" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Year should be between 1582 to 8000"));
    }

    /**
     *
     * This method is used to test ValidateLeapYear Returns Not a Valid Year for year -22.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsNotAValidYearForValueLessThanZero() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/-22" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Year should be between 1582 to 8000"));
    }

    /**
     *
     * This method is used to test ValidateLeapYear Returns Not a Valid Year for year greater than 8000.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsNotAValidYearForValueGreaterThan8000() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/1231432432" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Year should be between 1582 to 8000"));
    }


    // Test case for First Use case

    /**
     * This method is used to test ValidateLeapYear Returns Leap Year for year 2000.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsLeapYearFor2000() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/2000" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("2000 is a Leap Year"));

    }

    // Test case for Second Use Case

    /**
     *
     * This method is used to test ValidateLeapYear Returns Not a Leap Year for year 1700.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsNotALeapYearFor1700() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/1700" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("1700 is not a Leap Year"));
    }

    /**
     *
     * This method is used to test ValidateLeapYear Returns Not a Leap Year for year 1800.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsNotALeapYearFor1800() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/1800" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("1800 is not a Leap Year"));
    }

    /**
     *
     * This method is used to test ValidateLeapYear Returns Not a Leap Year for year 1900.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsNotALeapYearFor1900() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/1900" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("1900 is not a Leap Year"));
    }

    /**
     *
     * This method is used to test ValidateLeapYear Returns Not a Leap Year for year 2100.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsNotALeapYearFor2100() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/2100" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("2100 is not a Leap Year"));
    }

    //Test Case for the third use case

    /**
     *
     * This method is used to test ValidateLeapYear Returns Leap Year for year 2008.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsLeapYearFor2008() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/2008" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("2008 is a Leap Year"));
    }

    /**
     *
     * This method is used to test ValidateLeapYear Returns Leap Year for year 2012.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsLeapYearFor2012() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/2012" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("2012 is a Leap Year"));
    }

    /**
     *
     * This method is used to test ValidateLeapYear Returns Leap Year for year 2016.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsLeapYearFor2016() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/2016" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("2016 is a Leap Year"));
    }


    //Test Case for the fourth Use Case

    /**
     *
     * This method is used to test ValidateLeapYear Returns Not a Leap Year for year 2017.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsNotALeapYearFor2017() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/2017" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("2017 is not a Leap Year"));
    }

    /**
     *
     * This method is used to test ValidateLeapYear Returns Not a Leap Year for year 2018.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsNotALeapYearFor2018() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/2018" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("2018 is not a Leap Year"));
    }

    /**
     *
     * This method is used to test ValidateLeapYear Returns Not a Leap Year for year 2019.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsNotALeapYearFor2019() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/2019" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("2019 is not a Leap Year"));
    }


    //Additional Rule Condition test case
    /**
     *
     * This method is used to test ValidateLeapYear Returns a Leap Year for year 8000.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsLeapYearFor8000() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/8000" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("8000 is a Leap Year"));
    }

    //Unit test cases for api which produces Json Result

    /**
     * This method is used to test the ValidateLeapYearJsonResponse method returns Not Found for invalid URI.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearJsonResponseReturnsNotFoundForInvalidURI() throws Exception {

        mockMvc.perform(get("/channels/validate/year-leap"))
                .andExpect(status().isNotFound());
    }

    /**
     *
     * This method is used to test  ValidateLeapYearJsonResponse Returns 400 when null year is not passed.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearJsonResponseReturnsBadRequestForNullYearsPassed() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year?year=")).andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     *
     * This method is used to test ValidateLeapYearJsonResponse Returns Year should be between 1582 to 8000.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearJsonResponseReturnsForValueLessThanZero() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year?year=-22")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.year").value("-22"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("Year should be between 1582 to 8000"));
    }

    /**
     *
     * This method is used to test ValidateLeapYearJsonResponse Returns Year should be between 1582 to 8000.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearJsonResponseReturnsForValueZero() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year?year=0")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.year").value("0"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("Year should be between 1582 to 8000"));
    }

    /**
     *
     * This method is used to test ValidateLeapYearJsonResponse Returns Year should be between 1582 to 8000.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearJsonResponseReturnsForValueGreaterThan8000() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year?year=8002")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.year").value("8002"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("Year should be between 1582 to 8000"));
    }
}