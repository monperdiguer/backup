import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author puente
 *
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestCommissionEmployee {

    /**
     * Test method for {@link CommissionEmployee#CommissionEmployee(java.lang.String, java.lang.String, java.lang.String, double, double)}.
     */
    @Test
    final void testCommissionEmployee() {
        CommissionEmployee employee = new CommissionEmployee("John", "Doe", "123-45-6789", 10000, 0.1);
        assertEquals("John", employee.getFirstName());
        assertEquals("Doe", employee.getLastName());
        assertEquals("123-45-6789", employee.getSocialSecurityNumber());
        assertEquals(10000, employee.getGrossSales(), 0.001);
        assertEquals(0.1, employee.getCommissionRate(), 0.001);
    }

    /**
     * Test method for {@link CommissionEmployee#setFirstName(java.lang.String)}.
     */
    @Test
    final void testSetFirstName() {
        CommissionEmployee employee = new CommissionEmployee("John", "Doe", "123-45-6789", 10000, 0.1);
        employee.setFirstName("Jane");
        assertEquals("Jane", employee.getFirstName());
    }

    /**
     * Test method for {@link CommissionEmployee#getFirstName()}.
     */
    @Test
    final void testGetFirstName() {
        CommissionEmployee employee = new CommissionEmployee("John", "Doe", "123-45-6789", 10000, 0.1);
        assertEquals("John", employee.getFirstName());
    }

    /**
     * Test method for {@link CommissionEmployee#setLastName(java.lang.String)}.
     */
    @Test
    final void testSetLastName() {
        CommissionEmployee employee = new CommissionEmployee("John", "Doe", "123-45-6789", 10000, 0.1);
        employee.setLastName("Smith");
        assertEquals("Smith", employee.getLastName());
    }

    /**
     * Test method for {@link CommissionEmployee#getLastName()}.
     */
    @Test
    final void testGetLastName() {
        CommissionEmployee employee = new CommissionEmployee("John", "Doe", "123-45-6789", 10000, 0.1);
        assertEquals("Doe", employee.getLastName());
    }

    /**
     * Test method for {@link CommissionEmployee#setSocialSecurityNumber(java.lang.String)}.
     */
    @Test
    final void testSetSocialSecurityNumber() {
        CommissionEmployee employee = new CommissionEmployee("John", "Doe", "123-45-6789", 10000, 0.1);
        employee.setSocialSecurityNumber("987-65-4321");
        assertEquals("987-65-4321", employee.getSocialSecurityNumber());
    }

    /**
     * Test method for {@link CommissionEmployee#getSocialSecurityNumber()}.
     */
    @Test
    final void testGetSocialSecurityNumber() {
        CommissionEmployee employee = new CommissionEmployee("John", "Doe", "123-45-6789", 10000, 0.1);
        assertEquals("123-45-6789", employee.getSocialSecurityNumber());
    }

    /**
     * Test method for {@link CommissionEmployee#setGrossSales(double)}.
     */
    @Test
    final void testSetGrossSales() {
        CommissionEmployee employee = new CommissionEmployee("John", "Doe", "123-45-6789", 10000, 0.1);
        employee.setGrossSales(20000);
        assertEquals(20000, employee.getGrossSales(), 0.001);
    }

    /**
     * Test method for {@link CommissionEmployee#getGrossSales()}.
     */
    @Test
    final void testGetGrossSales() {
        CommissionEmployee employee = new CommissionEmployee("John", "Doe", "123-45-6789", 10000, 0.1);
        assertEquals(10000, employee.getGrossSales(), 0.001);
    }

    /**
     * Test method for {@link CommissionEmployee#setCommissionRate(double)}.
     */
    @Test
    final void testSetCommissionRate() {
        CommissionEmployee employee = new CommissionEmployee("John", "Doe", "123-45-6789", 10000, 0.1);
        employee.setCommissionRate(0.2);
        assertEquals(0.2, employee.getCommissionRate(), 0.001);
    }

    /**
     * Test method for {@link CommissionEmployee#getCommissionRate()}.
     */
    @Test
    final void testGetCommissionRate() {
        CommissionEmployee employee = new CommissionEmployee("John", "Doe", "123-45-6789", 10000, 0.1);
        assertEquals(0.1, employee.getCommissionRate(), 0.001);
    }

    /**
     * Test method for {@link CommissionEmployee#earnings()}.
     */
    @Test
    final void testEarnings() {
        CommissionEmployee employee = new CommissionEmployee("John", "Doe", "123-45-6789", 10000, 0.1);
        assertEquals(1000, employee.earnings(), 0.001);
    }
}
