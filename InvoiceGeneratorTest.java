import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {
    InvoiceGenerator invoiceGenerator = null;
        @BeforeEach
        public void setUp() throws Exception {
            invoiceGenerator = new InvoiceGenerator();
        }
        @Test
        public void givenDistanceAndTime_ShouldReturnTotalFare() {
            double distance = 2.0;
            int time = 5;
            double fare = invoiceGenerator.calculateFare(distance, time);
            Assertions.assertEquals(25, fare, 0.0);//delta = 0.0
            //Expected Value = Result + Delta Value
        }
        @Test
        public void givenDistanceAndTime_ShouldReturnMIMIMUMFARE() {
            double distance = 0.1;
            int time = 1;
            double fare = invoiceGenerator.calculateFare(distance, time);
            Assertions.assertEquals(5, fare, 0.0);
        }
        /*@Test
        public void givenMuktipleRides_DistanceAndTime_ShouldReturnTotalFare() {
            Ride[] rides = { new Ride(2.0,5),
                    new Ride(0.1,1)};
            double fare = invoiceGenerator.calculateFare(rides);
            Assertions.assertEquals(30, fare, 0.0);
        }*/
        @Test
        public void givenMultiple_Rides_ShouldReturn_INVOICE_SUMMERY() {
            Ride[] rides = { new Ride(2.0,5),
                    new Ride(0.1,1)};
            InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
            InvoiceSummary expectedinvoicesummary = new InvoiceSummary(2,30.0);
            Assertions.assertEquals(expectedinvoicesummary, summary);
        }
}
