
package com.ex.soap;

import javax.jws.WebService;

@WebService(endpointInterface = "com.ex.soap.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
    	System.out.println("SERVICE!");
        return "Hello " + text;
    }
    
}

