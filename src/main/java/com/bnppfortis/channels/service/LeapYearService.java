package com.bnppfortis.channels.service;

import com.bnppfortis.channels.constants.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * This class contains the common Utility methods which are needed for my application.
 * <p>
 * Created by Dev2018039 on 12/22/2018.
 */
@Service
public class LeapYearService {

    private static final Logger logger = LoggerFactory.getLogger(LeapYearService.class);
    /**
     * This method is used to determine whether the given year is Leap Year or Not.
     *
     * @param year - Integer
     * @return boolean - True or False
     */
    public boolean isLeapYear(int year) {
        logger.debug("Entered isLeapYear Service Method");
        return year > CommonConstants.ZERO && year <= CommonConstants.EIGHT_THOUSAND &&
                year % CommonConstants.FOUR == CommonConstants.ZERO &&
                (year % CommonConstants.HUNDRED != CommonConstants.ZERO
                        || year % CommonConstants.FOUR_HUNDRED == CommonConstants.ZERO);
    }
}