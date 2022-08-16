package space.eliseev.iplatformmoex.controller;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import space.eliseev.iplatformmoex.configuration.Config;
import space.eliseev.iplatformmoex.model.entity.ReferenceWithMOEX;
import space.eliseev.iplatformmoex.service.ReferenceWithMOEXService;


@Component
public class ReferenceWithMOEXController {
    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

    private ReferenceWithMOEXService referenceWithMOEXService = context.getBean("referenceWithMOEXService",ReferenceWithMOEXService.class);

    ReferenceWithMOEX referenceWithMOEX = referenceWithMOEXService.getReferenceWithMOEX();



}
