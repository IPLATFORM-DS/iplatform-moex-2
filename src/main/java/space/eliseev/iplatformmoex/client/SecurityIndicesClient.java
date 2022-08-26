package space.eliseev.iplatformmoex.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static space.eliseev.iplatformmoex.client.SecurityIndicesClient.SEC_INDICES_URL;

@FeignClient(value = "securityIndices", url = SEC_INDICES_URL)
public interface SecurityIndicesClient {
    String SEC_INDICES_URL = "https://iss.moex.com/iss/securities";

    @GetMapping(value = "/{security}/indices.json?iss.meta=off&iss.only=data&iss.json=extended&only_actual=1")
    Object getSecurityIndices(@PathVariable String security);

}
