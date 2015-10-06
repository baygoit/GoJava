package com.Airbnb.app.model;

import com.Airbnb.app.validation.Validator;

/**
 * Created by romanroma on 26.09.15.
 */
public class Host extends User {

    public Host(String name, String surname, String email){
        super(name, surname, email);
    }

   // @Override
   // public boolean validation(){
   //     return super.validation() && Validator.validateUserCity(city);
   // }

}
