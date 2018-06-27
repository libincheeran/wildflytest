package com.libin.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AdderImpl implements AdderLocal,AdderRemote {

    /*@Inject
    Multiplier mul;*/

    @EJB
    Multiplier mul;

    // The below works.
    /*@EJB
    MultiplierLocal mul;*/

    @Override
    public void add() {
        System.out.println(" Adder Imple called");
        mul.multiply();
    }
}
