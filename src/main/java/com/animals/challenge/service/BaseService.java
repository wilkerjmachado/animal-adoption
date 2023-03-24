package com.animals.challenge.service;

import com.animals.challenge.exception.NotFoundException;
import com.animals.challenge.exception.ServiceException;
import com.animals.challenge.model.BaseEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<E extends BaseEntity> {

    @Transactional
    public Page<E> findAll(Pageable pageable) {

        return this.getRepository().findAll(pageable);
    }

    @Transactional
    public List<E> findAll() {

        return this.getRepository().findAll();
    }

    @Transactional
    public E findById(Long id) {

        return this.getRepository().findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public List<E> find(E entity) {

        return this.getRepository().findAll(Example.of(entity));
    }

    @Transactional
    public E save(E entity) {

        this.validate(entity);

        try {

            return this.getRepository().save(entity);

        } catch (Exception e) {

            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    public void remove(Long id) {

        this.validateDelete(this.getRepository().findById(id));

        this.getRepository().deleteById(id);
    }

    protected void validateDelete(Optional<E> entity) {

        entity.orElseThrow(NotFoundException::new);
    }

    protected void validate(E entity) {

        Optional.ofNullable(entity).orElseThrow(NotFoundException::new);
    }

    protected abstract JpaRepository<E, Long> getRepository();

}