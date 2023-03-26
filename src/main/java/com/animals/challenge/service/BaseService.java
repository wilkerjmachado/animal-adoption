package com.animals.challenge.service;

import com.animals.challenge.dto.BaseDto;
import com.animals.challenge.exception.NotFoundException;
import com.animals.challenge.exception.ServiceException;
import com.animals.challenge.model.BaseEntity;
import com.animals.challenge.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<E extends BaseEntity, D extends BaseDto<E>> {

    @Transactional
    public Page<E> findAll(String term, D filters, Pageable pageable) {

        return this.getRepository().findAll(this.getSpecification(term, filters), pageable);
    }

    @Transactional
    public E findById(Long id) {

        return this.getRepository().findById(id).orElseThrow(NotFoundException::new);
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
    public List<E> saveAll(List<E> entities) {

        entities.forEach(this::validate);

        try {

            return this.getRepository().saveAll(entities);

        } catch (Exception e) {

            throw new ServiceException(e.getMessage());
        }
    }

    protected void validate(E entity) {

        Optional.ofNullable(entity).orElseThrow(NotFoundException::new);
    }

    protected abstract BaseRepository<E> getRepository();

    protected abstract Specification<E> getSpecification(String term, D filters);

}