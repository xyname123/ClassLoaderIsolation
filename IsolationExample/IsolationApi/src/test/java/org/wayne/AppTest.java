package org.wayne;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.wayne.enums.EnvEnum;
import org.wayne.util.ClassLoaderUtil;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    @Test
    public void test1(){
        ClassLoaderUtil loaderUtil = new ClassLoaderUtil();
        System.out.println(loaderUtil.getModuleName(EnvEnum.A));
        System.out.println(loaderUtil.getModuleName(EnvEnum.B));
    }
}
