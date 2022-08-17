package space.eliseev.iplatformmoex.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.iplatformmoex.service.ReferenceWithMOEXService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/index.json")
public class ReferenceWithMOEXController {

    private ReferenceWithMOEXService service;

    @GetMapping
    public ResponseEntity getReferenceWithMOEX(){
        return ResponseEntity.ok(service.getReferenceWithMOEX());
    }

}
