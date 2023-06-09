package com.SpringBoot.Form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    FormRepository formRepository;
    @Override
    public Form regUser(String fullName, String username, String email, String password, String conPassword, Date birthday, String gender) {

        Form form = new Form();
        form.setFullName(fullName);
        form.setUsername(username);
        form.setEmail(email);
        form.setPassword(password);
        form.setConPassword(conPassword);
        form.setBirthday(birthday);
        form.setGender(gender);

        formRepository.save(form);
        return form;

    }
}
