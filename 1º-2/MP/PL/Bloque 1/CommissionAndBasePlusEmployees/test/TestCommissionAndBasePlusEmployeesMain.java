import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCommissionAndBasePlusEmployeesMain {

    @Test
    final void testMaxEarnings() {
        // Case 1: The maximum earnings belong to a BasePlusCommissionEmployee
        CommissionEmployee[] v1 = new CommissionEmployee[] {
            new CommissionEmployee("John", "Doe", "123-45-6789", 5000, 0.1), // 500.0
            new CommissionEmployee("Alice", "Smith", "987-65-4321", 7000, 0.15) // 1050.0
        };

        BasePlusCommissionEmployee[] v2 = new BasePlusCommissionEmployee[] {
            new BasePlusCommissionEmployee("Bob", "Brown", "111-22-3333", 3000, 0.2, 500), // 1100.0
            new BasePlusCommissionEmployee("Charlie", "Davis", "444-55-6666", 4000, 0.1, 800) // 1200.0
        };

        // Call the maxEarnings method
        double result = CommissionAndBasePlusEmployeesMain.maxEarnings(v1, v2);

        // Verify that the maximum earnings are 1200.0 (BasePlusCommissionEmployee)
        assertEquals(1200.0, result, 0.001, "The maximum earnings should be 1200.0");
  
        // Case 2: The maximum earnings belong to a CommissionEmployee
        v1 = new CommissionEmployee[] {
            new CommissionEmployee("John", "Doe", "123-45-6789", 5000, 0.1), // 500.0
            new CommissionEmployee("Alice", "Smith", "987-65-4321", 20000, 0.1) // 2000.0 (maximum)
        };

        v2 = new BasePlusCommissionEmployee[] {
            new BasePlusCommissionEmployee("Bob", "Brown", "111-22-3333", 3000, 0.2, 500), // 1100.0
            new BasePlusCommissionEmployee("Charlie", "Davis", "444-55-6666", 4000, 0.1, 800) // 1200.0
        };

        // Call the maxEarnings method
        result = CommissionAndBasePlusEmployeesMain.maxEarnings(v1, v2);

        // Verify that the maximum earnings are 2000.0 (CommissionEmployee)
        assertEquals(2000.0, result, 0.001, "The maximum earnings should be 2000.0");
    }

    


    @Test
    void testGenerateSortedEarnings() {
        // Arrange: Create test data
        CommissionEmployee[] v1 = {
            new CommissionEmployee("Alice", "Smith", "123-45-6789", 5000, 0.1), // 500.0
            new CommissionEmployee("Bob", "Brown", "234-56-7890", 3000, 0.15)   // 450.0
        };

        BasePlusCommissionEmployee[] v2 = {
            new BasePlusCommissionEmployee("Charlie", "Davis", "345-67-8901", 4000, 0.1, 800), // 1200.0
            new BasePlusCommissionEmployee("Diana", "Evans", "456-78-9012", 2000, 0.2, 600)   // 1000.0
        };

        // Prepare expected output
        double[] expectedEarnings = {450.0, 500.0, 1000.0, 1200.0};

        // Prepare output array
        double[] v3 = new double[v1.length + v2.length];

        // Act: Call the method
        CommissionAndBasePlusEmployeesMain.generateSortedEarnings(v1, v2, v3);

        // Assert: Check that the output array matches the expected earnings
        assertArrayEquals(expectedEarnings, v3, "The sorted earnings should match the expected order");

        // Additional assertion: Check correct order of workers' salaries
        assertTrue(v3[0] <= v3[1] && v3[1] <= v3[2] && v3[2] <= v3[3],
            "The earnings array should be sorted in ascending order");
    }

    @Test
    void testGenerateSortedEarningsWithEmptyInputs() {
        // Arrange: Empty input arrays
        CommissionEmployee[] v1 = {};
        BasePlusCommissionEmployee[] v2 = {};

        // Prepare expected output
        double[] expectedEarnings = {};

        // Prepare output array
        double[] v3 = new double[v1.length + v2.length];

        // Act: Call the method
        CommissionAndBasePlusEmployeesMain.generateSortedEarnings(v1, v2, v3);

        // Assert: Check that the output array is empty
        assertArrayEquals(expectedEarnings, v3, "The sorted earnings should be an empty array for empty inputs");
    }

    @Test
    void testGenerateSortedEarningsWithSingleEmployee() {
        // Arrange: One employee in each array
        CommissionEmployee[] v1 = {
            new CommissionEmployee("Alice", "Smith", "123-45-6789", 6000, 0.1) // 600.0
        };

        BasePlusCommissionEmployee[] v2 = {
            new BasePlusCommissionEmployee("Charlie", "Davis", "345-67-8901", 2000, 0.2, 500) // 900.0
        };

        // Prepare expected output
        double[] expectedEarnings = {600.0, 900.0};

        // Prepare output array
        double[] v3 = new double[v1.length + v2.length];

        // Act: Call the method
        CommissionAndBasePlusEmployeesMain.generateSortedEarnings(v1, v2, v3);

        // Assert: Check that the output array matches the expected earnings
        assertArrayEquals(expectedEarnings, v3, "The sorted earnings should match the expected order for one employee in each class");
    }
}