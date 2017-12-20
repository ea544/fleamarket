package org.fleamarket.service;

import java.util.concurrent.atomic.AtomicLong;

import org.fleamarket.domain.Confirmation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfirmationController {
	
	private static final String template = "Hello, %s. Please goto the <a href='login'>Login Page</a> to sign in!";
    private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping("/confirmation")
    @ResponseBody
    public Confirmation confirmation(@RequestParam(value="name", defaultValue="Weolcome") String name) {
        return new Confirmation(counter.incrementAndGet(), String.format(template, name));
    }

}
