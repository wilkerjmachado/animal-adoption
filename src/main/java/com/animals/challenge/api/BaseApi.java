package com.animals.challenge.api;

import com.animals.challenge.model.BaseEntity;
import com.animals.challenge.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseApi<E extends BaseEntity, S extends BaseService<E>> {

    protected abstract S getService();

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/pageable", params = { "page", "size" })
    public ResponseEntity<Page<E>> findPageable(@RequestParam("page") int page, @RequestParam("size") int size) {

        return ResponseEntity.ok(this.getService().findAll(PageRequest.of(page, size)));
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity<List<E>> findAll() {

        return ResponseEntity.ok(this.getService().findAll());
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<E> findById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(this.getService().findById(id));

    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/find")
    public ResponseEntity<List<E>> find(@RequestBody E entity) {

        return ResponseEntity.ok(this.getService().find(entity));
    }
}
