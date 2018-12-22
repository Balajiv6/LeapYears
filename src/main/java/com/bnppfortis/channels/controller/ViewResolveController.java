package com.bnppfortis.channels.controller;

import com.bnppfortis.channels.constants.CommonConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class will acts a view resolver for loading my page.
 *
 * Created by Dev2018039 on 12/22/2018.
 */
@Controller
public class ViewResolveController {

    /**
     * This method is used to resolve the web page leap year for the given URI.
     *
     * @return String - leapyear.html is returned
     */
    @RequestMapping("/leapyear")
    public String leapYear() {

        return CommonConstants.LEAP_YEAR_RESOLVER;
    }
}
