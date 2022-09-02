package space.eliseev.iplatformmoex.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.client.SecurityClient;
import space.eliseev.iplatformmoex.configuration.UrlConfig;
import space.eliseev.iplatformmoex.service.SecurityIndicesService;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class SecurityIndicesServiceImpl implements SecurityIndicesService {
    private final SecurityClient client;
    private final UrlConfig urlConfig;

    @SneakyThrows
    @Override
    public Object getSecurityIndices(String security) {
        return client.getSecurityIndices(new URI(urlConfig.getIndices(security)));
    }
}
