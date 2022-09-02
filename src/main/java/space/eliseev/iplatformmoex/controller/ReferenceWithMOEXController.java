package space.eliseev.iplatformmoex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.iplatformmoex.service.ReferenceWithMOEXService;

import java.util.List;

@RestController
@RequestMapping("/index")
public class ReferenceWithMOEXController {


    private ReferenceWithMOEXService service;

    @Autowired
    public ReferenceWithMOEXController(ReferenceWithMOEXService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getReferenceWithMOEX(){
        List<Object> reference = service.getReferenceWithMOEX();
        return new ResponseEntity(reference.get(1), HttpStatus.OK);
    }

}
