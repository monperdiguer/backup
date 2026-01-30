import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBasePlusCommissionEmployeeMain {

    @Test
    void testSortEmployees() {
        // Create an array of employees
        BasePlusCommissionEmployee[] employees = {
            new BasePlusCommissionEmployee("John", "Doe", "111-22-3333", 5000.0, 0.05, 1000.0),
            new BasePlusCommissionEmployee("Jane", "Smith", "222-33-4444", 4000.0, 0.06, 1200.0),
            new BasePlusCommissionEmployee("Alice", "Johnson", "333-44-5555", 3000.0, 0.04, 1500.0)
        };

        // Call sortEmployees (ascending by earnings)
        BasePlusCommissionEmployeeMain.sortEmployees(employees);

        // Expected order (sorted by earnings)
        assertEquals("Alice", employees[0].getFirstName(), "First employee should be Alice.");
        assertEquals("Jane", employees[1].getFirstName(), "Second employee should be Jane.");
        assertEquals("John", employees[2].getFirstName(), "Third employee should be John.");
    }

    @Test
    void testMaxEarningsEmployeeEqualEarnings() {
        // Create an array where two employees have the same highest earnings
        BasePlusCommissionEmployee[] employees = {
            new BasePlusCommissionEmployee("John", "Doe", "111-22-3333", 5000.0, 0.05, 1000.0), // Earnings: 1250.0
            new BasePlusCommissionEmployee("Jane", "Smith", "222-33-4444", 5000.0, 0.05, 1000.0), // Earnings: 1250.0
            new BasePlusCommissionEmployee("Alice", "Johnson", "333-44-5555", 3000.0, 0.07, 1500.0)  // Earnings: 1710.0
        };

        // Call maxEarningsEmployee
        BasePlusCommissionEmployee maxEarningsEmployee = BasePlusCommissionEmployeeMain.maxEarningsEmployee(employees);

        // Validate the result
        assertNotNull(maxEarningsEmployee, "The result should not be null.");
        assertEquals("Alice", maxEarningsEmployee.getFirstName(), "The employee with the highest earnings should be Alice.");
    }
}
