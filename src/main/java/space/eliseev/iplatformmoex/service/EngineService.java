package space.eliseev.iplatformmoex.service;

import org.springframework.lang.Nullable;

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
}