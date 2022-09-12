package space.eliseev.iplatformmoex.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import space.eliseev.iplatformmoex.model.dto.ReferenceWithMOEX.ReferenceWithMOEXJsonDto;
import space.eliseev.iplatformmoex.model.enumeration.Engine;

import java.net.URI;
import java.util.List;


@FeignClient(value = "MOEX-api", url = "index")
public interface ReferenceWithMOEXClient {

    @GetMapping
    List<ReferenceWithMOEXJsonDto> getReferenceWithMOEX(URI indexUri,
                                                        @RequestParam(value = "lang", required = false) String lang,
                                                        @RequestParam(value = "engine", required = false) Engine engine,
                                                        @RequestParam(value = "is_traded", required = false) Integer isTraded,
                                                        @RequestParam(value = "hide_inactive", required = false) Integer hideInactive,
                                                        @RequestParam(value = "trade_engine", required = false) String tradeEngine);
}