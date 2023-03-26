package com.animals.challenge.repository.specification;

import com.animals.challenge.dto.AnimalDto;
import com.animals.challenge.model.Animal;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalSpecification implements Specification<Animal> {

    private AnimalDto filters;

    private String term;

    @Override
    public Predicate toPredicate(Root<Animal> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicateList = new ArrayList<>();

        if(StringUtils.hasText(term)){

            Predicate predicateName = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%"+term.toLowerCase()+"%");

            Predicate predicateDesc = criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%"+term.toLowerCase()+"%");

            predicateList.add(criteriaBuilder.or(predicateName, predicateDesc));
        }

        if(Objects.nonNull(filters)){

            if(Objects.nonNull(filters.getStatus())){

                predicateList.add(criteriaBuilder.equal(root.get("status"), filters.getStatus()));
            }

            if(Objects.nonNull(filters.getCategory())){

                predicateList.add(criteriaBuilder.equal(root.get("category"), filters.getCategory()));
            }

            if(Objects.nonNull(filters.getCreatedAt())){

                predicateList.add(criteriaBuilder.equal(root.get("createdAt"), filters.getCreatedAt()));
            }
        }

        Predicate[] predicates = new Predicate[predicateList.size()];

        return criteriaBuilder.and(predicateList.toArray(predicates));
    }
}
