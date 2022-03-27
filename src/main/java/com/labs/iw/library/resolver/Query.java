package com.labs.iw.library.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.labs.iw.library.entity.Application;
import com.labs.iw.library.entity.Student;
import com.labs.iw.library.repository.ApplicationRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private ApplicationRepository applicationRepository;

    public Query(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Iterable<Application> findAllApplications() {
        return applicationRepository.findAll();
    }

    public long countApplications() {
        return applicationRepository.count();
    }
    
    public List<Student> findAllStudents() {
   	 List<Student> lista = new ArrayList<>();
   	 Student student1 = new Student();
   	 student1.setIme("Nikola");
   	 student1.setPrezime("Popovski");
   	 
   	 lista.add(student1);
   	 
       return lista;
   }
}