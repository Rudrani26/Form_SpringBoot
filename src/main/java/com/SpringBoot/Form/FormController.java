package com.SpringBoot.Form;

import jakarta.validation.Valid;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class FormController {

    @Autowired
    private FormService formService;

   @GetMapping("/")
    public String register() {
        return "RegPage";
    }

    @PostMapping(path = "/registerUser")
    public String regUser(
            @RequestParam(value ="fullName") String fullName,
            @RequestParam(value ="username") String username,
            @RequestParam(value ="email") String email,
            @RequestParam(value ="password") String password,
            @RequestParam(value ="conPassword") String conPassword,
            @RequestParam(value ="birthday") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday,
            @RequestParam(value ="gender") String gender
            ) throws JSONException {

//        if (!bindingResult.hasErrors()) {
            Form form = formService.regUser(fullName, username, email, password, conPassword, birthday, gender);

            JSONObject resObj = new JSONObject();
            resObj.put("username", form.getUsername());
            resObj.put("fullName", form.getFullName());
            resObj.put("email", form.getEmail());
            resObj.put("password", form.getPassword());
            resObj.put("conPassword", form.getConPassword());
            resObj.put("birthday", form.getBirthday());
            resObj.put("gender", form.getGender());
            resObj.toString();
//        }

        return "message";
    }
}

//package com.SpringBoot.Form;
//
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class FormController {
//
//    @Autowired
//    private FormService formService;
//
//    @GetMapping("/")
//    public String register() {
//        return "RegPage";
//    }
//
//    @PostMapping(path = "/registerUser")
//    public String regUser(@Valid Form form, BindingResult bindingResult){
//        if (!bindingResult.hasErrors())
//            formService.regUser(form);
//            return "message";
//    }
//}

