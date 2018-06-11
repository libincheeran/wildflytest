package com.libin.ejb;

import javax.ejb.Stateless;

@Stateless
public class TextProcessorBean implements TextProcessorRemote {
    @Override
    public String processText(String text) {
        return "Hello "+text;
    }
}
