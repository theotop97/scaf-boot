package com.scaf.config.result;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SourceHandler {
    private Locale defaultLocale;
    private final Map<Locale, Resource> cache = new ConcurrentHashMap();

    public SourceHandler() {
        this.defaultLocale = Locale.SIMPLIFIED_CHINESE;
    }

    public SourceHandler(Locale locale) {
        this.defaultLocale = locale;
    }

    public SourceHandler.Resource resource(HttpServletRequest httpServletRequest) {
        return this.locals(this.getLocalByRequest(httpServletRequest));
    }

    private Locale getLocalByRequest(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getLocale();
    }

    private SourceHandler.Resource locals(Locale locale) {
        if (!this.cache.containsKey(locale)) {
            this.cache.put(locale, new SourceHandler.Resource(locale));
        }

        return (SourceHandler.Resource)this.cache.get(locale);
    }

    public class Resource {
        private final Locale locale;
        private volatile Properties properties;

        public Resource(Locale locale) {
            this.locale = locale;
        }

        public Optional<String> property(String code) {
            Properties properties = this.properties();
            return properties == null ? Optional.empty() : Optional.ofNullable(properties.getProperty(code));
        }

        private Properties properties() {
            if (this.properties == null) {
                synchronized(this) {
                    if (this.properties == null) {
                        try {
                            InputStreamReader inputStreamReader = new InputStreamReader(this.getPropertyInputStream(this.locale), Charset.forName("UTF-8"));
                            Throwable var3 = null;

                            try {
                                this.properties = new Properties();
                                this.properties.load(inputStreamReader);
                            } catch (Throwable var15) {
                                var3 = var15;
                                throw var15;
                            } finally {
                                if (inputStreamReader != null) {
                                    if (var3 != null) {
                                        try {
                                            inputStreamReader.close();
                                        } catch (Throwable var14) {
                                            var3.addSuppressed(var14);
                                        }
                                    } else {
                                        inputStreamReader.close();
                                    }
                                }

                            }
                        } catch (NullPointerException | IOException var17) {
                        }
                    }
                }
            }

            return this.properties;
        }

        private InputStream getPropertyInputStream(Locale locale) {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream(this.propertiesByLocale(locale));
            return inputStream == null ? ClassLoader.getSystemResourceAsStream(this.propertiesByLocale(SourceHandler.this.defaultLocale)) : inputStream;
        }

        private String propertiesByLocale(Locale locale) {
            return locale.toString() + ".properties";
        }
    }
}
