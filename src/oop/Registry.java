package oop;

import java.util.*;

class CustomerRegistry {
    // Опять же реализуем паттерн Singleton, чтобы у нас был только один регистр
    private static CustomerRegistry customerRegistry;

    private final String uuid;
    private final Map<String, Customer> customers = new HashMap<>();

    // Доступ к этому классу есть только у регистра, поэтому все операции происходят только через него
    private static class Customer {
        private final String uuid;
        private final String name;

        Customer(String name) {
            this.uuid = UUID.randomUUID().toString();
            this.name = name;
            System.out.println("Creating new Customer " + this.uuid);
        }

        public String getUuid() {
            return uuid;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "uuid='" + uuid + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }

        public void print() {
            System.out.println(this);
        }
    }

    private CustomerRegistry() {
        this.uuid = UUID.randomUUID().toString();
        System.out.println("Creating new CustomRegistry " + this.uuid);
    }

    public static CustomerRegistry getInstance() {
        if (customerRegistry == null) {
            customerRegistry = new CustomerRegistry();
        }

        return customerRegistry;
    }

    public String addCustomer(String name) {
        Customer customer = new Customer(name);
        this.customers.put(
                customer.getUuid(),
                customer
        );

        return customer.getUuid();
    }

    public void deleteCustomer(String uuid) {
        System.out.println("Deleting customer " + uuid);
       this.customers.remove(uuid);
    }

    @Override
    public String toString() {
        return "CustomerRegistry{" +
                "uuid='" + uuid + '\'' +
                ", customers=" + customers +
                '}';
    }

    public void print() {
        System.out.println(this);
    }
}
public class Registry {
    public static void main(String[] args) {
        CustomerRegistry csg = CustomerRegistry.getInstance();

        String csId = csg.addCustomer("Vadim");
        csg.deleteCustomer(csId);
    }
}
