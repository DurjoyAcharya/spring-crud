package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
record Student(String name,String Address){}
@RestController
public class Message {


    @GetMapping("value")
    public String executor() throws InterruptedException {
        AtomicReference<String> str= new AtomicReference<>("");
        var thread=new Thread(()->{
            for (int i = 0; i < 10; i++) {
                int finalI = i;
                str.updateAndGet(v -> v + " "+finalI);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
        thread.join();
        return String.valueOf(str);
    }
    public ArrayList<Student> getvalues()
    {
        var list=new ArrayList<Student>();
        list.add(new Student("Dipak Kumer Das","Biri siri"));
        list.add(new Student("Rohit Kumer","Biri siri"));
        list.add(new Student("Mandi kool","Tangail ------"));
        return (ArrayList<Student>) list.stream().filter(e->e.name().startsWith("D")).collect(Collectors.toList());
    }
}
