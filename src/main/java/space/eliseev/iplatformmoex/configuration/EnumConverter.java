package space.eliseev.iplatformmoex.configuration;

import lombok.SneakyThrows;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;

@Component
public class EnumConverter implements GenericConverter {
    private final Set<ConvertiblePair> pairSet =
            Collections.singleton(new ConvertiblePair(String.class, Enum.class));

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return pairSet;
    }

    @SneakyThrows
    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
            assert source != null;
            return targetType
                    .getType()
                    .getMethod("valueOf", sourceType.getType())
                    .invoke(null, source.toString().toUpperCase());
    }
}
