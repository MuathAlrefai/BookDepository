package com.axsos.bookdepository.services;


import com.axsos.bookdepository.models.Purchase;
import com.axsos.bookdepository.repositories.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public Purchase createPurchase(Purchase purchase){
        return purchaseRepository.save(purchase);
    }

    public Purchase updatePurchase(Purchase purchase){
        return purchaseRepository.save(purchase);
    }

    public void deletePurchase(Long id){
        purchaseRepository.deleteById(id);
    }

    public List<Purchase> allPurchases(){
        return purchaseRepository.findAll();
    }

    public Purchase findPurchase(Long id){
        Optional<Purchase> optionalPurchase = purchaseRepository.findById(id);
        if(optionalPurchase.isPresent()){
            return optionalPurchase.get();
        }else {
            return null;
        }
    }
}
