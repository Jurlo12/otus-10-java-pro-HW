package homework;

import java.util.*;

public class CustomerService {

    private final NavigableMap<Customer, String> customerService = new TreeMap<>(Comparator.comparingLong(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        Set<Map.Entry<Customer, String>> customerSet = customerService.entrySet();
        for (Map.Entry<Customer, String> it : customerSet)
        {
            var smallestCustomer = it.getKey();
            Customer copyCustomer = new Customer(
                    smallestCustomer.getId(),
                    smallestCustomer.getName(),
                    smallestCustomer.getScores());

            return new java.util.AbstractMap.SimpleEntry<Customer, String>(copyCustomer, it.getValue());
        }
        return null;
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        if (customerService.higherEntry(customer) != null) {
            var nextCustomer = customerService.higherEntry(customer).getKey();
            Customer copyCustomer = new Customer(
                    nextCustomer.getId(),
                    nextCustomer.getName(),
                    nextCustomer.getScores());
            return new java.util.AbstractMap.SimpleEntry<Customer, String>(copyCustomer, customerService.higherEntry(customer).getValue());
        }
        return null;
    }

    public void add(Customer customer, String data) {
        customerService.put(customer, data);
    }
}
