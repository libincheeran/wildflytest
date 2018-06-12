package com.libin.ejb;

import com.libin.entity.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TextProcessorBean implements TextProcessorRemote {

    @PersistenceContext(unitName = "ARS-PU")
    private EntityManager entityManager;

    @Override
    public String processText(String text) {
        Product p = new Product();
        p.setId((double) 123456);
        p.setName(text);
        p.setMultivendor("Y");
        p.setVendorEligSelection("N");

        entityManager.persist(p);

        return "Done persisting Hello "+text;
    }
}
