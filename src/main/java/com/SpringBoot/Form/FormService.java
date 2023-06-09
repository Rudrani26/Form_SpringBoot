package com.SpringBoot.Form;

import java.util.Date;

public interface FormService {

    public Form regUser(String fullName, String username, String email, String password, String conPassword, Date birthday, String gender);

}





















//safe code without AJAX
//package com.SpringBoot.Form;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class FormService {
//
//    @Autowired
//    private FormRepository formRepository;
//
//    public Form regUser(){
//        formRepository.save(form);
//        return null;
//    }
//
//}
