package com.app.global.config.jpa;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.util.StringUtils;

import java.util.Optional;
public class AuditorAwareImpl implements AuditorAware<String> {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Override
    public Optional<String> getCurrentAuditor() {
        String requestURI = httpServletRequest.getRequestURI();
        if (!StringUtils.hasText(requestURI)) {
            requestURI = "unknown";
        }
        return Optional.of(requestURI);
    }
}
