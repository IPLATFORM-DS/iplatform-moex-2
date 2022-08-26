package space.eliseev.iplatformmoex.service;

import org.springframework.stereotype.Service;

@Service
public interface SecurityIndicesService {

    Object getSecurityIndices(String security);
}
