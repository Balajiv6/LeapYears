package com.bnppfortis;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This Class is used to test the Spring Boot App.
 *
 * Created by Dev2018039 on 12/22/2018.
 */
@RunWith(SpringRunner.class)
public class SpringBootAppTest extends TestCase {

    /**
     * This method is to test whether the Spring Boot App Main method is invoked.
     * @throws Exception
     */
    @Test
    public void testSpringBootAppMainMethod() throws Exception {
        SpringBootApp.main(new String[]{});
    }
}