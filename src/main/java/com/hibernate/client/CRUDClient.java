package com.hibernate.client;

import com.hibernate.model.Address;
import com.hibernate.model.Student;
import com.hibernate.service.CRUDService;

public class CRUDClient {
    public static void main(String[] args) {

        CRUDService crudService = new CRUDService();

        // insert student record 1
        Address address = new Address("Maharashtra", "Mumbai");
        Student student = new Student("soniya sherkar", "sherkarsoniya@gmail.com", address);

        crudService.insertStudentRecord(student);
    }
}
