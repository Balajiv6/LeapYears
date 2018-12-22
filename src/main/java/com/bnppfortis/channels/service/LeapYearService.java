package com.bnppfortis.channels.service;

import com.bnppfortis.channels.constants.CommonConstants;
import org.springframework.stereotype.Service;

/**
 * This class contains the common Utility methods which are needed for my application.
 * <p>
 * Created by Dev2018039 on 12/22/2018.
 */
@Service
public class LeapYearService {

    /**
     * This method is used to determine whether the given year is Leap Year or Not.
     *
     * @param year - Integer
     * @return boolean - True or False
     */
    public boolean isLeapYear(int year) {
        boolean isLeapYearValue = false;
        if (year > CommonConstants.LEAST_VALUE && year <= CommonConstants.EIGHT_THOUSAND) {
            if (year % CommonConstants.FOUR == CommonConstants.ZERO &&
                    (year % CommonConstants.HUNDRED != CommonConstants.ZERO
                            || year % CommonConstants.FOUR_HUNDRED == CommonConstants.ZERO)) {
                isLeapYearValue = true;
            }
        }
        return isLeapYearValue;
    }
}