package com.libin.ejb;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class EjbClient {

    public static void main(String[] args) {
        EjbClient c = new EjbClient();
        String libin = c.call("Libin");
        System.out.println(libin);
    }

    public String call(String name){
        try {
            TextProcessorRemote textProcessorBeanFromJNDI = EJBFactory.fromJNDI("ejb:");
            return textProcessorBeanFromJNDI.processText(name);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static class EJBFactory {

        private static TextProcessorRemote fromJNDI(String namespace) throws NamingException {
            return lookupBean(namespace);
        }

        private static TextProcessorRemote lookupBean(String namespace) throws NamingException {
            Context ctx = createInitialContext();
            String appName = "ars";
            String moduleName = "web";
            String distinctName = "";
            String beanName = TextProcessorBean.class.getSimpleName();
            String viewClassName = TextProcessorRemote.class.getName();
            String jndiLookupUrl =
                    namespace +
                            appName + "/" +
                            moduleName +"/"+
                            distinctName + "/" +
                            beanName + "!" +
                            viewClassName;
            System.out.println(jndiLookupUrl);
            return (TextProcessorRemote) ctx.lookup(jndiLookupUrl);
        }

        private static Context createInitialContext() throws NamingException {
            Properties jndiProperties = new Properties();
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
                    "org.jboss.naming.remote.client.InitialContextFactory");
            jndiProperties.put(Context.URL_PKG_PREFIXES,
                    "org.jboss.ejb.client.naming");
            jndiProperties.put(Context.PROVIDER_URL,
                    "http-remoting://localhost:8080");
            jndiProperties.put("jboss.naming.client.ejb.context", true);
            return new InitialContext(jndiProperties);
        }
    }
}
