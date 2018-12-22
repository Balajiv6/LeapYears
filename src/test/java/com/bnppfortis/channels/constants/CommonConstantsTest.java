package com.bnppfortis.channels.constants;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * Created by Dev2018039 on 12/22/2018.
 */
@RunWith(SpringRunner.class)
public class CommonConstantsTest extends TestCase {

    /**
     * This method is used to test the default Common Constant constructor.
     * @throws Exception
     */
    @Test
    public void testDefaultConstructCommonConstants() throws Exception {
        CommonConstants commonConstants = new CommonConstants();
        assertNotNull(commonConstants);
    }
}