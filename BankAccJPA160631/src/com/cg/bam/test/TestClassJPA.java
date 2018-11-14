package com.cg.bam.test;

import org.junit.Assert;
import org.junit.Test;

import com.cg.bam.exception.BamException;
import com.cg.bam.service.BamServiceImpl;

public class TestClassJPA {
	
	@Test
    public void testName_1() throws BamException{
    
        String name="Akshay";
        BamServiceImpl service=new BamServiceImpl();
        boolean result= service.validateName(name);
        Assert.assertEquals(true,result);
    }
    @Test
    public void testName_2() throws BamException{
    
        String name="john";
        BamServiceImpl service=new BamServiceImpl();
        boolean result= service.validateName(name);
        Assert.assertEquals(false,result);
    }
    
    
    @Test
    public void testMobile_1() throws BamException{
    
        String mobNo="RON123558";
        BamServiceImpl service=new BamServiceImpl();
        boolean result= service.validateMoileNo(mobNo);
        Assert.assertEquals(false,result);
    }
    @Test
    public void testMobile_2() throws BamException{
    
        String mobNo="9421734025";
        BamServiceImpl service=new BamServiceImpl();
        boolean result= service.validateMoileNo(mobNo);
        Assert.assertEquals(true,result);
    }


}
