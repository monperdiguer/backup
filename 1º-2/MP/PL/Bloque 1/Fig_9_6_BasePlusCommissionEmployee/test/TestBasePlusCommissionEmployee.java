import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestBasePlusCommissionEmployee {

    /**
     * Test method for {@link BasePlusCommissionEmployee#BasePlusCommissionEmployee(java.lang.String, java.lang.String, java.lang.String, double, double, double)}.
     */
    @Test
    final void testBasePlusCommissionEmployee() {
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(
                "John", "Doe", "123-45-6789", 10000, 0.1, 500);
        assertEquals("John", employee.getFirstName());
        assertEquals("Doe", employee.getLastName());
        assertEquals("123-45-6789", employee.getSocialSecurityNumber());
        assertEquals(10000, employee.getGrossSales(), 0.001);
        assertEquals(0.1, employee.getCommissionRate(), 0.001);
        assertEquals(500, employee.getBaseSalary(), 0.001);
    }

    /**
     * Test method for {@link BasePlusCommissionEmployee#setFirstName(java.lang.String)}.
     */
    @Test
    final void testSetFirstName() {
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(
                "John", "Doe", "123-45-6789", 10000, 0.1, 500);
        employee.setFirstName("Jane");
        assertEquals("Jane", employee.getFirstName());
    }

    /**
     * Test method for {@link BasePlusCommissionEmployee#getFirstName()}.
     */
    @Test
    final void testGetFirstName() {
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(
                "John", "Doe", "123-45-6789", 10000, 0.1, 500);
        assertEquals("John", employee.getFirstName());
    }

    /**
     * Test method for {@link BasePlusCommissionEmployee#setLastName(java.lang.String)}.
     */
    @Test
    final void testSetLastName() {
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(
                "John", "Doe", "123-45-6789", 10000, 0.1, 500);
        employee.setLastName("Smith");
        assertEquals("Smith", employee.getLastName());
    }

    /**
     * Test method for {@link BasePlusCommissionEmployee#getLastName()}.
     */
    @Test
    final void testGetLastName() {
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(
                "John", "Doe", "123-45-6789", 10000, 0.1, 500);
        assertEquals("Doe", employee.getLastName());
    }

    /**
     * Test method for {@link BasePlusCommissionEmployee#setSocialSecurityNumber(java.lang.String)}.
     */
    @Test
    final void testSetSocialSecurityNumber() {
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(
                "John", "Doe", "123-45-6789", 10000, 0.1, 500);
        employee.setSocialSecurityNumber("987-65-4321");
        assertEquals("987-65-4321", employee.getSocialSecurityNumber());
    }

    /**
     * Test method for {@link BasePlusCommissionEmployee#getSocialSecurityNumber()}.
     */
    @Test
    final void testGetSocialSecurityNumber() {
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(
                "John", "Doe", "123-45-6789", 10000, 0.1, 500);
        assertEquals("123-45-6789", employee.getSocialSecurityNumber());
    }

    /**
     * Test method for {@link BasePlusCommissionEmployee#setGrossSales(double)}.
     */
    @Test
    final void testSetGrossSales() {
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(
                "John", "Doe", "123-45-6789", 10000, 0.1, 500);
        employee.setGrossSales(20000);
        assertEquals(20000, employee.getGrossSales(), 0.001);
    }

    /**
     * Test method for {@link BasePlusCommissionEmployee#getGrossSales()}.
     */
    @Test
    final void testGetGrossSales() {
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(
                "John", "Doe", "123-45-6789", 10000, 0.1, 500);
        assertEquals(10000, employee.getGrossSales(), 0.001);
    }

    /**
     * Test method for {@link BasePlusCommissionEmployee#setCommissionRate(double)}.
     */
    @Test
    final void testSetCommissionRate() {
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(
                "John", "Doe", "123-45-6789", 10000, 0.1, 500);
        employee.setCommissionRate(0.2);
        assertEquals(0.2, employee.getCommissionRate(), 0.001);
    }

    /**
     * Test method for {@link BasePlusCommissionEmployee#getCommissionRate()}.
     */
    @Test
    final void testGetCommissionRate() {
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(
                "John", "Doe", "123-45-6789", 10000, 0.1, 500);
        assertEquals(0.1, employee.getCommissionRate(), 0.001);
    }

    /**
     * Test method for {@link BasePlusCommissionEmployee#setBaseSalary(double)}.
     */
    @Test
    final void testSetBaseSalary() {
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(
                "John", "Doe", "123-45-6789", 10000, 0.1, 500);
        employee.setBaseSalary(1000);
        assertEquals(1000, employee.getBaseSalary(), 0.001);
    }

    /**
     * Test method for {@link BasePlusCommissionEmployee#getBaseSalary()}.
     */
    @Test
    final void testGetBaseSalary() {
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(
                "John", "Doe", "123-45-6789", 10000, 0.1, 500);
        assertEquals(500, employee.getBaseSalary(), 0.001);
    }

    /**
     * Test method for {@link BasePlusCommissionEmployee#earnings()}.
     */
    @Test
    final void testEarnings() {
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(
                "John", "Doe", "123-45-6789", 10000, 0.1, 500);
        assertEquals(1500, employee.earnings(), 0.001);
    }
}
