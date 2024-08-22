package com.farkasatesz.shopping_list.models.supermarkets;

import com.farkasatesz.shopping_list.exceptions.supermarketExceptions.SupermarketException;
import com.farkasatesz.shopping_list.exceptions.supermarketExceptions.SupermarketNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupermarketService {

    private final SupermarketRepository supermarketRepository;

    @Autowired
    public SupermarketService(SupermarketRepository supermarketRepository) {
        this.supermarketRepository = supermarketRepository;
    }

    public List<Supermarket> findSupermarketsByQuery(String query) {
        return supermarketRepository.findBySupermarketNameLikeIgnoreCase(query);
    }

    @Transactional
    public Supermarket createSupermarket(Supermarket supermarket) {
        try {
            supermarket.setSupermarketId(null);
            return supermarketRepository.save(supermarket);
        } catch (RuntimeException e) {
            throw new SupermarketException("Could not create supermarket", e);
        }
    }

    @Transactional
    public Supermarket updateSupermarket(Integer supermarketId, Supermarket supermarket) {
        try {
            Supermarket supermarketToUpdate = supermarketRepository.findById(supermarketId).orElseThrow(() -> new SupermarketNotFoundException("Unable to find supermarket"));
            supermarketToUpdate.setSupermarketName(supermarket.getSupermarketName());
            return supermarketRepository.save(supermarketToUpdate);
        }catch (RuntimeException e){
            throw new SupermarketException("Could not update supermarket", e);
        }
    }

    @Transactional
    public void deleteSupermarket(Integer supermarketId) {
        try {
            supermarketRepository.deleteById(supermarketId);
        } catch (Exception e) {
            throw new SupermarketException("Could not delete supermarket", e);
        }
    }
}
