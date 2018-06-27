package com.libin.ejb;

import javax.ejb.Stateless;

@Stateless
public class MultiplierImpl implements MultiplierLocal,MultiplierRemote{

    @Override
    public void multiply() {
        System.out.println(" called multiplier ");
    }
}
