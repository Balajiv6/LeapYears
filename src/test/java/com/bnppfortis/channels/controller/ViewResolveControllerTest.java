package com.bnppfortis.channels.controller;

import com.bnppfortis.channels.constants.CommonConstants;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * Created by Dev2018039 on 12/22/2018.
 */
@RunWith(SpringRunner.class)
public class ViewResolveControllerTest extends TestCase {


    /**
     * This class is used to verify the LeapYear method returns the correct model leapyear.
     * @throws Exception
     */
    @Test
    public void testLeapYearReturnsCorrectModel() throws Exception {
        ViewResolveController viewResolveController = new ViewResolveController();
        assertEquals(viewResolveController.leapYear(), CommonConstants.LEAP_YEAR_RESOLVER);
    }


    /**
     * This class is used to verify the LeapYear method returns empty String.
     * @throws Exception
     */
    @Test
    public void testLeapYearReturnsEmptyString() throws Exception {
        ViewResolveController viewResolveController = Mockito.mock(ViewResolveController.class);
        Mockito.when(viewResolveController.leapYear()).thenReturn(" ");
        assertEquals(viewResolveController.leapYear(), " ");
    }
}