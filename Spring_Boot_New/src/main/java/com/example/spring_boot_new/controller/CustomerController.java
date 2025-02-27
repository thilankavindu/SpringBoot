package com.example.spring_boot_new.controller;

import com.example.spring_boot_new.dto.CustomerDTO;
import com.example.spring_boot_new.service.CustomerService;
import com.example.spring_boot_new.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
        @Autowired
        private CustomerService customerService;

        @PostMapping("save")
        public ResponseUtil saveCustomer(@RequestBody CustomerDTO customerDTO) {
            boolean isSaved = customerService.addCustomer(customerDTO);
            if (isSaved){
                return new ResponseUtil(201,"customer saved",null);
            }else{
                return new ResponseUtil(200,"exit customer",null);
            }

        }

    @GetMapping("getAll")
    public ArrayList<CustomerDTO> getCustomer() {
        return customerService.getAllCustomers();
    }

    @PutMapping("update")
    public String updateCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.addCustomer(customerDTO);
        return customerDTO.toString();
    }

    @DeleteMapping("delete/{id}")
    public String deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return "Customer Deleted with id " + id;
    }
}

