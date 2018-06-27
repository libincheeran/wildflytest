package com.libin.service;

import com.libin.ejb.Adder;

import javax.ejb.EJB;

public class Service {

    @EJB(name = "ejb/Adder")
    private Adder add;
}
