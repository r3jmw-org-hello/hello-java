package org.hello.config.filer;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class TenantFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(TenantFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tenantId = request.getHeader("X-Tenant-Id");
        if(!AllowedTenant.isAllowedTenant(tenantId)) {
            logger.info("No Tenant ID Found");
            throw new AccessDeniedException("Access Denied");
        }
    }

    @Getter
    public enum AllowedTenant {
        SERVICE("Service"),
        CLIENT("Client");

        private String tenant;

        AllowedTenant(String tenant) {
            this.tenant = tenant;
        }

        public String getName() {
            return tenant;
        }

        public void setName(String name) {
            this.tenant = name;
        }

        public static boolean isAllowedTenant(String tenantId) {
            for (AllowedTenant allowedTenant: AllowedTenant.values()) {
                if(allowedTenant.getName().equals(tenantId)) return true;
            }
            return false;
        }
    }
}
