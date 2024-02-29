package com.example.school;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schools")
public class SchoolController {

    private final SchoolService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  void save(
            @RequestBody School school
    ){
        service.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>>findAllschools(){
        return  ResponseEntity.ok(service.findAllschools());
    }
@GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse>findAllschools(@PathVariable("school-id") Integer schoolId){
    return  ResponseEntity.ok(service.findschoolsWithStudents(schoolId));
}

}
