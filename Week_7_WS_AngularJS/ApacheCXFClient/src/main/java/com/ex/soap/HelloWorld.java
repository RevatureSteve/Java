package com.ex.soap;


import javax.jws.WebService;


/**
 *  Client needs interface to program against
 *  
 */
@WebService
public interface HelloWorld {
    String sayHi(String text);
}

