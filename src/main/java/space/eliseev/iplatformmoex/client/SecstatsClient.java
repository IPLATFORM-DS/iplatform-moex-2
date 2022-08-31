package space.eliseev.iplatformmoex.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.net.URI;

@FeignClient(value = "secstats", url = "secstats")
public interface SecstatsClient {
    @GetMapping
    Object getSecstats(URI secstatsUri,
                       @RequestParam(name="tradingsession", required = false) Integer tradingsession,
                       @RequestParam(name="securities", required = false) String securities,
                       @RequestParam(name="boardid", required = false) String boardid);
}

