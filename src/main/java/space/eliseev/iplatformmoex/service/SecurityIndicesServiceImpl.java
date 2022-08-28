package space.eliseev.iplatformmoex.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.client.SecurityClient;
//import space.eliseev.iplatformmoex.client.SecurityIndicesClient;

@Service
@RequiredArgsConstructor
public class SecurityIndicesServiceImpl implements SecurityIndicesService {

    private final SecurityClient client;

    @Override
    public Object getSecurityIndices(String security) {
        return client.getSecurityIndices(security);
    }
}
