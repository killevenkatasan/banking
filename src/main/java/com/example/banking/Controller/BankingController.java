package com.example.banking.Controller;

import com.example.banking.Entity.BankingEntity;
import com.example.banking.Service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/banking")
@RestController
public class BankingController {
    @Autowired
    private BankingService bankingService;

    @PostMapping("/CreateAccount")
    public String addAccount(@RequestBody BankingEntity bankingEntity) {
        return bankingService.add(bankingEntity);
    }

    @GetMapping("/View")
    public List<BankingEntity> getAll() {
        return bankingService.get();
    }

    @GetMapping("/search/{id}")
    public Optional<BankingEntity> getId(@PathVariable Long id) {
        return bankingService.getById(id);
    }

    @PutMapping("/update/{id}")
    public  String updateAll(@PathVariable Long id, @RequestBody BankingEntity bankingEntity)
    {
        return bankingService.update(id,bankingEntity);
    }
    @GetMapping("/deactive/{id}")
    public ResponseEntity<String> deact(@PathVariable Long id){
        Optional<BankingEntity> deactive = bankingService.deact(id);
        return ResponseEntity.ok("Customer with ID " + id + " has been deactivated successfully.");

    }
    @GetMapping("/active")
    public List<BankingEntity> getActiveCustomers() {
        return bankingService.getAllActiveCustomers();
    }

    @PostMapping
    public BankingEntity addCustomer(@RequestBody BankingEntity customer) {
        return bankingService.addCustomer(customer);
    }
    @GetMapping("/highincome")
    public List<BankingEntity> getHighIncomeCustomers() {
        return bankingService.getHighIncomeCustomers();
    }
    @GetMapping
    public ResponseEntity<List<BankingEntity>> getCustomers(
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String order) {

        List<BankingEntity> customers = bankingService.getAllCustomersSorted(sortBy, order);
        return ResponseEntity.ok(customers);
    }
}
