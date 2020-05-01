package ua.lviv.iot.spring.first.rest.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ua.lviv.iot.spring.first.rest.bussiness.AccessoryService;
import ua.lviv.iot.spring.first.rest.models.Accessory;

@RequestMapping("/products")
@RestController
public class AccessoryController {

    @Autowired
    private AccessoryService accessoryService;

    @GetMapping
    public final List<Accessory> getAccessories() {
        return accessoryService.getAccessories();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Accessory> getAccessory(final @PathVariable("id") Integer id) {
        Accessory accessoryNow;
        return (accessoryNow = accessoryService.getAccessory(id)) == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(accessoryNow, HttpStatus.OK);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public final Accessory createAccessory(final @RequestBody Accessory accessory) {
        return accessoryService.createAccessory(accessory);
    }

    @DeleteMapping(path = "/{id}")
    public final ResponseEntity<Accessory> deleteAccessory(final @PathVariable("id") Integer id) {
        HttpStatus status = accessoryService.deleteAccessory(id) ? HttpStatus.OK :
                HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status);
    }

    @PutMapping(path = "/{id}")
    public final ResponseEntity<Accessory> updateAccessory(final @PathVariable("id") Integer id,
                                                           final @RequestBody Accessory accessory) {
        accessory.setId(id);
        Accessory previousAccessory;
        return (previousAccessory = accessoryService.updateAccessory(id, accessory)) == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(previousAccessory, HttpStatus.OK);
    }
}
