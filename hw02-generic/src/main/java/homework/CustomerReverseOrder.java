package homework;

import java.util.LinkedList;

public class CustomerReverseOrder {

    LinkedList<Customer> reverseCustomer = new LinkedList<Customer>();

    public void add(Customer customer) {
        reverseCustomer.add(customer);
    }

    public Customer take() {
        return reverseCustomer.removeLast();
    }
}
