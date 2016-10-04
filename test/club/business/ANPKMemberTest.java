/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package club.business;

import junit.framework.TestCase;

/**
 *
 * @author pkornilov
 */
public class ANPKMemberTest extends TestCase {
    
    public ANPKMemberTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getFullName method, of class Member.
     */
    public void testGetFullName() {
        System.out.println("getFullName");
        Member instance = new Member();
        String expResult = "";
        String result = instance.getFullName();
        assertEquals(expResult, result);
    }


    /**
     * Test of getEmailAddress method, of class Member.
     */
    public void testGetEmailAddress() {
        System.out.println("getEmailAddress");
        Member instance = new Member();
        String expResult = "";
        String result = instance.getEmailAddress();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getPhoneNumber method, of class Member.
     */
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        Member instance = new Member();
        String expResult = "226-987-1350";
        instance.setPhoneNumber(expResult);
        assertEquals(expResult, instance.getPhoneNumber());

    }


    /**
     * Test of getProgramName method, of class Member.
     */
    public void testGetProgramName() {
        System.out.println("getProgramName");
        Member instance = new Member();
        String expResult = "ITID";
        instance.setProgramName(expResult);
        assertEquals(expResult, instance.getProgramName());
    }


    /**
     * Test of getYearLevel method, of class Member.
     */
    public void testGetYearLevel() {
        System.out.println("getYearLevel");
        Member instance = new Member();
        int expResult = 2015;
        instance.setYearLevel(expResult);
        assertEquals(expResult, instance.getYearLevel());
    }
    
    /**
     * Test of isValid method, of class Member
     */
    public void testValidNegative(){
        System.out.println("isValidNegative");
        Member instance=new Member("Philippe Kornilov", null);
        boolean expResult=false;
        boolean result=instance.isValid();
        assertEquals(expResult, result);
        
    }
    public void testValidPositive(){
        System.out.println("isValidPositive");
        Member instance=new Member("Philippe Kornilov", "pkornilov21@gmail.com");
        boolean expResult=true;
        boolean result=instance.isValid();
        assertEquals(expResult, result);
    }
    
}
