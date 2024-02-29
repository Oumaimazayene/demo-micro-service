package com.example.school;

import com.example.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository studentRepository;
    @Autowired
    private StudentClient client;
    public void saveSchool (School school ){
        studentRepository.save(school);

    }
    public List<School> findAllschools(){
        return studentRepository.findAll();
    }

    public FullSchoolResponse findschoolsWithStudents(Integer schoolId) {
var school = studentRepository.findById(schoolId)
        .orElse(School.builder().
                name("NOT_FOUND").
                email("NOT_FOUND").build());
var students= client.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder().
                name(school.getName())
                .email(school.getEmail())
                .students(students)
        .build() ;
    }
}
