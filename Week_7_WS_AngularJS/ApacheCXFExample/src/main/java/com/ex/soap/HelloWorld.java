package com.ex.soap;

import javax.jws.WebService;


/**
 * WSDL location -> http://localhost:8085/ApacheCXFExample/HelloWorld?WSDL
 * 
 * @author TJ
 */
@WebService
public interface HelloWorld {
    String sayHi(String text);
}

