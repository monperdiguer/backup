import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCommissionEmployeeMain {

    @Test
    void testSortEmployees() {
        // Create some CommissionEmployee objects
        CommissionEmployee employee1 = new CommissionEmployee("John", "Doe", "111-22-3333", 5000, 0.05);
        CommissionEmployee employee2 = new CommissionEmployee("Jane", "Smith", "444-55-6666", 7000, 0.07);
        CommissionEmployee employee3 = new CommissionEmployee("Mark", "Johnson", "777-88-9999", 6000, 0.06);

        CommissionEmployee[] employees = {employee1, employee2, employee3};

        // Call the sortEmployees method
        CommissionEmployeeMain.sortEmployees(employees);

        // Test that employees are sorted by earnings in descending order
        assertEquals(employee2, employees[0], "The employee with the lowest earnings should be first.");
        assertEquals(employee3, employees[1], "The second lowest earnings should be second.");
        assertEquals(employee1, employees[2], "The employee with the highest earnings should be last.");
        
        // Call the maxEarningsEmployee method and test
        CommissionEmployee maxEarningsEmployee = CommissionEmployeeMain.maxEarningsEmployee(employees);
        assertEquals(employee2, maxEarningsEmployee, "The employee with the highest earnings should be Jane Smith.");
    }
    

}
