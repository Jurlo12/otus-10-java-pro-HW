package homework;

import java.util.Deque;
import java.util.LinkedList;

public class CustomerReverseOrder {

    private final Deque<Customer> reverseCustomer = new LinkedList<Customer>();

    public void add(Customer customer) {
        reverseCustomer.add(customer);
    }

    public Customer take() {
        return reverseCustomer.removeLast();
    }
}
