package homework;

import java.util.*;

public class CustomerService {

    private final NavigableMap<Customer, String> customers = new TreeMap<>(Comparator.comparingLong(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        var smallCustomer = customers.firstEntry().getKey();
        Customer copyCustomer = new Customer(
                smallCustomer.getId(),
                smallCustomer.getName(),
                smallCustomer.getScores());
            return new java.util.AbstractMap.SimpleEntry<Customer, String>(copyCustomer, customers.firstEntry().getValue());
        }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        if (customers.higherEntry(customer) != null) {
            var nextCustomer = customers.higherEntry(customer).getKey();
            Customer copyCustomer = new Customer(
                    nextCustomer.getId(),
                    nextCustomer.getName(),
                    nextCustomer.getScores());
            return new java.util.AbstractMap.SimpleEntry<Customer, String>(copyCustomer, customers.higherEntry(customer).getValue());
        }
        return null;
    }

    public void add(Customer customer, String data) {
        customers.put(customer, data);
    }
}
