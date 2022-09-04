package space.eliseev.iplatformmoex.service;


import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.Index;

import java.util.List;


@Service
public interface ReferenceWithMOEXService {

    Object  getReferenceWithMOEX(@Nullable Index param,
                                       @Nullable  String lang,
                                       @Nullable Engine engine,
                                       @Nullable  Integer isTraded,
                                       @Nullable Integer hideInactive,
                                       @Nullable String securitygroup,
                                       @Nullable  String tradeEngine);
}
