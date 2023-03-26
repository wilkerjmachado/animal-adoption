package com.animals.challenge.api;

import com.animals.challenge.dto.BaseDto;
import com.animals.challenge.model.BaseEntity;
import com.animals.challenge.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseApi<E extends BaseEntity, D extends BaseDto<E>, S extends BaseService<E, D>> {

    protected abstract S getService();

    @ResponseBody
    @RequestMapping(method = RequestMethod.PATCH, value = "/{id}")
    public ResponseEntity<E> update(@RequestBody D dto, @PathVariable("id") Long id) {

        E entity = this.getService().findById(id);

        dto.updateEntity(entity);

        return ResponseEntity.ok(this.getService().save(entity));
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/pageable")
    public ResponseEntity<Page<E>> findPageable(@RequestParam(value = "page", defaultValue = "0") int page,
                                                @RequestParam(value = "size", defaultValue = "10") int size,
                                                @RequestParam(value = "term", required = false) String term,
                                                @RequestBody(required = false) D filters) {

        return ResponseEntity.ok(this.getService().findAll(term, filters, PageRequest.of(page, size)));
    }

}
