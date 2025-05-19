package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.Base;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.example.EcommerceBackJem.repositories.BaseRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public abstract class BaseService<E extends Base, ID extends Serializable> {

    protected BaseRepository<E, ID> baseRepository;

    public BaseService(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Transactional
    public List<E> findAll() throws Exception {
        try {
            return baseRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

    }

    @Transactional
    public Optional<E> findById(ID id) throws Exception {
        try {
            return Optional.ofNullable(baseRepository.findById(id).orElse(null));
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Transactional
    public E save(E entity) throws Exception {
        try {
            return baseRepository.save(entity);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Transactional
    public E update(E entity) throws Exception {
        try {
            return baseRepository.save(entity);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Transactional
    public void delete(ID id) throws Exception {
        Optional<E> entityOptional = baseRepository.findById(id);
        if (entityOptional.isPresent()) {
            E entity = entityOptional.get();
            entity.setActivo(false);
            baseRepository.save(entity);
        } else {
            throw new Exception("Entidad no encontrada");
        }
    }
}