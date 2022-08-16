package space.eliseev.iplatformmoex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import space.eliseev.iplatformmoex.model.entity.ReferenceWithMOEX;

@Component
public class ReferenceWithMOEXServiceImpl implements ReferenceWithMOEXService{

    private RestTemplate restTemplate;
    private final String URL = "https://iss.moex.com/iss/index.json";

    @Autowired
    public ReferenceWithMOEXServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ReferenceWithMOEX getReferenceWithMOEX(){
        ResponseEntity<ReferenceWithMOEX> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<ReferenceWithMOEX>(){});
        return responseEntity.getBody();
    }


}
