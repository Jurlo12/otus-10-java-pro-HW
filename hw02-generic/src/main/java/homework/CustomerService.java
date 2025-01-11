package homework;

import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class CustomerService {

    NavigableMap<Customer, String> customerService = new TreeMap<>(Comparator.comparingLong(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        Customer copyCustomer = new Customer(customerService.firstEntry().getKey().getId(),
                customerService.firstEntry().getKey().getName(), customerService.firstEntry().getKey().getScores());
        TreeMap<Customer, String> subMap = new TreeMap<>(Comparator.comparingLong(Customer::getScores));
        subMap.put(copyCustomer, customerService.lastEntry().getValue());
        return subMap.firstEntry();
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        if(customerService.higherEntry(customer) != null) {
            Customer copyCustomer = new Customer(customerService.higherEntry(customer).getKey().getId(),
                    customerService.higherEntry(customer).getKey().getName(),
                    customerService.higherEntry(customer).getKey().getScores());
            TreeMap<Customer, String> nextMap = new TreeMap<>(Comparator.comparingLong(Customer::getScores));
            nextMap.put(copyCustomer, customerService.higherEntry(customer).getValue());
            return nextMap.firstEntry();
        }
        return null;
    }

    public void add(Customer customer, String data) {
        customerService.put(customer, data);
    }
}
