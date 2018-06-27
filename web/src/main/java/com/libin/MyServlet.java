package com.libin;

import com.libin.ejb.Adder;
import com.libin.ejb.AdderLocal;
import com.libin.ejb.Multiplier;

import javax.ejb.EJB;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {

    @EJB(name = "ejb/Adder")
    private Adder add;

    /*@EJB(name = "ejb/Multiplier")
    Multiplier mul;*/

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" got Request ");
        /*String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        String domain = request.getParameter("domain");
        LoginContext loginContext = null;
        try {
            loginContext = new LoginContext(domain, new LoginCallbackHandler(uname, pwd));
            loginContext.login();

            Subject subject = loginContext.getSubject();


            for( Principal p : subject.getPrincipals()){

                System.out.println(p.getName());
            }

        } catch (LoginException e) {
            e.printStackTrace();
        }
        Principal userPrincipal = request.getUserPrincipal();
        System.out.println(" principal "+userPrincipal);
        System.out.println(" principal "+userPrincipal.getName());*/




        /*EjbClient c = new EjbClient();
        String uppName = c.call("Libin");
        System.out.println(" upp name now is "+ uppName);*/

        System.out.println(" from servlet @Ejb call");
        add.add();
        //mul.multiply();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    static class LoginCallbackHandler implements CallbackHandler {
        private String username = null;
        private String password = null;

        public LoginCallbackHandler(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
            for (int i = 0; i < callbacks.length; i++) {
                if (callbacks[i] instanceof NameCallback) {
                    NameCallback nc = (NameCallback) callbacks[i];
                    nc.setName(username);
                } else if (callbacks[i] instanceof PasswordCallback) {
                    PasswordCallback pc = (PasswordCallback) callbacks[i];
                    pc.setPassword(password.toCharArray());
                }
            }
        }
    }
}
