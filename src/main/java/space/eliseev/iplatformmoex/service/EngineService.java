package space.eliseev.iplatformmoex.service;

import org.springframework.lang.Nullable;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.EngineParam;

import java.net.URISyntaxException;

/**
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
public interface EngineService {

    /**
     * Получить доступные торговые системы
     *
     * @param lang Язык результата: ru или en
     * @return список доступных торговых систем
     */
    Object getEngines(@Nullable String lang);

    Object getEngine(Engine engine, @Nullable EngineParam param, @Nullable String lang) throws URISyntaxException;
}