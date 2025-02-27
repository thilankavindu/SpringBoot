package com.example.spring_boot_new.service;

import com.example.spring_boot_new.dto.CustomerDTO;
import com.example.spring_boot_new.entity.Customer;
import com.example.spring_boot_new.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    //data save
    public boolean addCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getId())) {
            return false;
            }
        Customer customer = new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress());
        customerRepo.save(customer);
        return true;
    }

    public ArrayList<CustomerDTO> getAllCustomers() {
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        customerRepo.findAll().forEach(customer -> customerDTOS.add(new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress())));
        return customerDTOS;
    }


    public void deleteCustomer(int id) {
        customerRepo.deleteById(id);
    }

    public void updateCustomer(CustomerDTO customerDTO) {
        customerRepo.save(new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress()));
    }
}
