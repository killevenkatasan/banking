package com.example.banking.Service;

import com.example.banking.Entity.BankingEntity;
import com.example.banking.Repository.BankingRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
@Data
@Service
public class BankingService {
    @Autowired
    private BankingRepository bankingRepository;
    public String add(BankingEntity bankingEntity)
    {
        BankingEntity sc = new BankingEntity();
        sc.setName(bankingEntity.getName());
        sc.setEmail(bankingEntity.getEmail());
        sc.setPhoneNumber(bankingEntity.getPhoneNumber());
        sc.setDate(bankingEntity.getDate());
        sc.setAddress(bankingEntity.getAddress());
        sc.setCountry(bankingEntity.getCountry());
        sc.setCity(bankingEntity.getCity());
        sc.setIncome(bankingEntity.getIncome());
        bankingRepository.save(sc);
        return "Create Successfully";

    }
    public List<BankingEntity> get()
    {
        return bankingRepository.findAll();
    }
    public Optional<BankingEntity> getById(Long id)
    {
        Optional<BankingEntity> Id =bankingRepository.findById(id);
        return Id;
    }
    public String update(Long id, BankingEntity bankingEntity)
    {
        Optional<BankingEntity> updated = bankingRepository.findById(id);
        BankingEntity up = updated.get();
        up.setName(bankingEntity.getName());
        up.setEmail(bankingEntity.getEmail());
        up.setPhoneNumber(bankingEntity.getPhoneNumber());
        up.setAddress(bankingEntity.getAddress());
        up.setDate(bankingEntity.getDate());
        up.setCountry(bankingEntity.getCountry());
        up.setCity(bankingEntity.getCity());
        up.setIncome(bankingEntity.getIncome());
        bankingRepository.save(up);
        return "The given Information Updated Successfully";
    }
    public Optional<BankingEntity> deact(Long id)
    {
        Optional<BankingEntity> deactive = bankingRepository.findById(id);
        BankingEntity customer = deactive.get();
        customer.setActive(false);
        bankingRepository.save(customer);
        return Optional.of(customer);

    }
    public List<BankingEntity> getAllActiveCustomers() {
        return bankingRepository.findByActiveTrue();
    }
    public BankingEntity addCustomer(BankingEntity bankingEntity)
    {
        int age = Period.between(bankingEntity.getDateOfBirth(), LocalDate.now()).getYears();
        bankingEntity.setAge((long) age);
        if (age < 18) {
            throw new IllegalArgumentException("Customer must be at least 18 years old");

    }
        return bankingRepository.save(bankingEntity);
    }
    public List<BankingEntity> getHighIncomeCustomers() {
        return bankingRepository.findByIncomeGreaterThan(100000L);
    }
    public List<BankingEntity> getAllCustomersSorted(String sortBy, String order) {
        Sort sort = order.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() :
                Sort.by(sortBy).ascending();

        return bankingRepository.findAll(sort);
    }
}
