package com.gutsfun.aadspringbootresourceserversample.controller;

import com.azure.spring.aad.webapi.AADOAuth2AuthenticatedPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleController.class);

    @GetMapping("admin")
    @PreAuthorize("hasRole('ROLE_Admin')")
    public AADOAuth2AuthenticatedPrincipal gtAdminPrincipal(Authentication authentication) {
        LOGGER.info("Admin has access");
        return (AADOAuth2AuthenticatedPrincipal) authentication.getPrincipal();
    }

    @GetMapping("user")
    @PreAuthorize("hasRole('ROLE_User')")
    public AADOAuth2AuthenticatedPrincipal getUserPrincipal(Authentication authentication) {
        LOGGER.info("User has access");
        return (AADOAuth2AuthenticatedPrincipal) authentication.getPrincipal();
    }
}
