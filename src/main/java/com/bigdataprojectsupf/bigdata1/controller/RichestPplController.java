package com.bigdataprojectsupf.bigdata1.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigdataprojectsupf.bigdata1.entity.RichestPpl;
import com.bigdataprojectsupf.bigdata1.repo.RichestPplRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping(path = "api/richestppl")
public class RichestPplController {
    private RichestPplRepository richestPplRepository;

    @Autowired
    public RichestPplController(RichestPplRepository richestPplRepository) {
        this.richestPplRepository = richestPplRepository;
    }
   @GetMapping
    public List<RichestPpl> getRichestPpls(){
        return richestPplRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public RichestPpl getOne(@PathVariable String id){
        UUID targetId = UUID.fromString(id);
        RichestPpl foundRichestPpl = null;
        foundRichestPpl = this.richestPplRepository.findById(targetId);
        /* List<RichestPpl> people = richestPplRepository.findAll();
        RichestPpl foundRichestPpl = null;
        for (RichestPpl richestPpl : people) {
            if (richestPpl.getId().equals(targetId)) {
                foundRichestPpl = richestPpl;
                break;
            }
        } */
        return foundRichestPpl;
    }

    @PostMapping("/update")
    public RichestPpl updateRichestPpl(@RequestBody RichestPpl richestppl) {
     RichestPpl foundRichestPpl = this.richestPplRepository.findById(richestppl.getId());
           foundRichestPpl.setName(richestppl.getName());
        foundRichestPpl.setAge(richestppl.getAge());
        foundRichestPpl.setCountry(richestppl.getCountry());
        foundRichestPpl.setIndustry(richestppl.getIndustry());
        foundRichestPpl.setNetworth(richestppl.getNetworth());
        foundRichestPpl.setSource(richestppl.getSource());
        this.richestPplRepository.save(foundRichestPpl);  
        return richestppl;
    }
    

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> getMethodName(@PathVariable String id) {
        UUID idRichest = UUID.fromString(id);
        this.richestPplRepository.deleteById(idRichest);
        return ResponseEntity.ok("Employee deleted successfully");
    }
    

    
    @PostMapping
    public RichestPpl newRichestRpl(@RequestBody RichestPpl richestPpl) {
        return (RichestPpl) richestPplRepository.save(new RichestPpl(richestPpl.getName(),richestPpl.getAge(),richestPpl.getCountry(),richestPpl.getIndustry(),richestPpl.getNetworth(), richestPpl.getSource())); 
    }

    
}
