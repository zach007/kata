package com.hsbc.kata.parallelchange.method;

public class ClientOfAuthenticator {
    private AuthenticationService authenticationService;

    public ClientOfAuthenticator(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public static void main(String[] args) {
        new ClientOfAuthenticator(new AuthenticationService()).run();
    }

    public void run() {
        boolean authenticated = authenticationService.isAuthenticated(33);
        System.out.println("33 is authenticated = " + authenticated);
    }
}
