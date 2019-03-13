package com.stackroute.MuzixApp.service.seeder;

import com.stackroute.MuzixApp.service.domain.Muzix;
import com.stackroute.MuzixApp.service.exception.MuzixAlreadyExistException;
import com.stackroute.MuzixApp.service.service.MuzixServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class MySeeder implements ApplicationListener<ContextRefreshedEvent> {


    private MuzixServiceImpl muzixService;

    @Autowired
    public MySeeder(MuzixServiceImpl muzixService) {
        this.muzixService = muzixService;
    }

    @Value("${trackName1}")
    String name1;
    @Value("${comment1}")
    String comment1;


    //to store default data in database using ApplicationListener method
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Muzix muzix = new Muzix(null, name1, comment1);
        try {
            muzixService.saveMuzix(muzix);
        } catch (MuzixAlreadyExistException e) {
            e.printStackTrace();
        }
    }
//
//    @Value("${trackName2}")
//    String name2;
//    @Value("${comment2}")
//    String comment2;


    //to store default data in database using CommandLineRunner method
//    @Override
//    public void run(String... args) throws Exception {
//
//        Muzix muzix = new Muzix("0", name2, comment2);
//
//        muzixService.saveMuzix(muzix);
//    }
}
