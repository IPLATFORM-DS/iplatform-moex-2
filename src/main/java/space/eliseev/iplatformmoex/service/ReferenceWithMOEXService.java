package space.eliseev.iplatformmoex.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@FeignClient(value = "MOEX-api", url = "https://iss.moex.com/iss/")
public interface ReferenceWithMOEXService {

    @RequestMapping(method = RequestMethod.GET, value = "/index.json?iss.json=extended")
    List<Object> getReferenceWithMOEX();
}
