package com.week2.mongodb.controller;

import com.week2.mongodb.model.Presiden;
import com.week2.mongodb.service.PresidenService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/presiden")
@Log4j2
public class PresidenContoller {

    @Autowired
    private PresidenService presidenService;

    @PostMapping(value = "")
    public ResponseEntity<Presiden> createPresiden(@RequestBody Presiden presiden) {
        return ResponseEntity.ok().body(presidenService.createPresiden(presiden));
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Presiden>> getAllPresiden() {
        return ResponseEntity.ok().body(presidenService.getAllPresiden());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Presiden> getPresidenById(@PathVariable Long id) {
        log.info(id);
        return ResponseEntity.ok().body(presidenService.getPresidenById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Presiden> updatePresiden(@PathVariable Long id, @RequestBody Presiden presiden) {
        presiden.setId(id);
        return ResponseEntity.ok().body(presidenService.updatePresiden(presiden));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePresiden(@PathVariable Long id) {
        presidenService.deletePresiden(id);
        return ResponseEntity.ok().body("SUCCESS DELETE");
    }

}
