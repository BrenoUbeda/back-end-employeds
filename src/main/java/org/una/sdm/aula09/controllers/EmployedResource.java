package org.una.sdm.aula09.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.sdm.aula09.domain.Employed;
import org.una.sdm.aula09.services.interfaces.EmployedServiceAPI;

import javax.xml.ws.Service;
import java.util.List;

@RestController
@RequestMapping("/employeds")
@CrossOrigin()
public class EmployedResource {

    @Autowired
    private EmployedServiceAPI employedService;

    @GetMapping
    public @ResponseBody
    HttpEntity<List<Employed>> findAll() {

        List<Employed> employeds = employedService.findAll();
        return ResponseEntity.ok(employeds);
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity<Employed> get(@PathVariable(name = "id") Long id) {

        Employed employed = employedService.get(id);
        return ResponseEntity.ok(employed);
    }

    @PostMapping
    public @ResponseBody
    HttpEntity<Employed> create(@RequestBody Employed employed) {

        employed = employedService.create(employed);
        return ResponseEntity.ok(employed);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Employed> update(@PathVariable(name = "id") Long id,
            @RequestBody Employed employed) {

        employed.setId(id);
        employedService.update(employed);
        return ResponseEntity.ok(employed);
    }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Employed> remove(@PathVariable(name = "id") Long id) {

        employedService.remove(id);
        return ResponseEntity.ok().build();
    }
}
