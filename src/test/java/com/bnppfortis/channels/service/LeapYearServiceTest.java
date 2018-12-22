package com.bnppfortis.channels.service;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * This is the Class where will be defining the test for LeapYearService.
 *
 * <p>
 * Created by Dev2018039 on 12/22/2018.
 */
@RunWith(Parameterized.class)
public class LeapYearServiceTest extends TestCase {

    private int year;
    private boolean expectedResult;

    private LeapYearService leapYearService;

    /**
     * Constructor
     *
     * @param year - Integer
     * @param expectedResult - boolean
     */
    public LeapYearServiceTest(int year,boolean expectedResult){
        super();
        this.year = year;
        this.expectedResult = expectedResult;
    }

    @Before
    public void initialize(){
        leapYearService = new LeapYearService();

    }
    /**
     *
     * Since the same logic is repeated rather than writing multiple test case we can create a parameterized test case.
     *
     * @return Collection of inputYears along with the Expected Result
     */
    @Parameterized.Parameters
    public static Collection inputYearsAndExpectedOutputArray(){
        return Arrays.asList(new Object[][]{
                {-22, false}, {0, false}, {1234123, false}, {2000, true},
                {1700, false}, {1800, false}, {1900, false}, {2100, false},
                {2017, false}, {2018, false}, {2019, false}, {2016, true},
                {2012, true}, {2004, true}, {8000, true}
        });
    }

    /**
     * This method is used to test isLeapYear Method against the Parameterized values.
     *
     * @throws Exception
     */
    @Test
    public void testIsLeapYear() throws Exception {
        assertEquals(expectedResult, leapYearService.isLeapYear(year));
    }
}