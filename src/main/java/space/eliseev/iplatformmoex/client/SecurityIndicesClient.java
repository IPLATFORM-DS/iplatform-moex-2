package space.eliseev.iplatformmoex.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

@FeignClient(value = "securityIndices", url = "securityIndices")
public interface SecurityIndicesClient {
    @GetMapping
    Object getSecurityIndices(URI indicesUri);

}
