package org.entando.entando.keycloak.services;

import com.agiletec.aps.system.EntThreadLocal;
import org.apache.commons.lang3.StringUtils;
import org.entando.entando.aps.system.services.tenant.ITenantManager;
import org.entando.entando.aps.system.services.tenant.TenantConfig;
import org.springframework.beans.factory.annotation.Autowired;

public class KeycloakConfiguration {

    private boolean enabled;
    private String authUrl;
    private String realm;
    private String clientId;
    private String clientSecret;
    private String publicClientId;
    private String secureUris;
    private String defaultAuthorizations;
    
    private ITenantManager tenantManager;

    public boolean isEnabled() {
        TenantConfig config = this.getCurrentConfig();
        if (null != config) {
            return config.isKcEnabled();
        }
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public String getAuthUrl() {
        TenantConfig config = this.getCurrentConfig();
        if (null != config) {
            return config.getKcAuthUrl();
        }
        return authUrl;
    }
    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    public String getRealm() {
        TenantConfig config = this.getCurrentConfig();
        if (null != config) {
            return config.getKcRealm();
        }
        return realm;
    }
    public void setRealm(String realm) {
        this.realm = realm;
    }

    public String getClientId() {
        TenantConfig config = this.getCurrentConfig();
        if (null != config) {
            return config.getKcClientId();
        }
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        TenantConfig config = this.getCurrentConfig();
        if (null != config) {
            return config.getKcClientSecret();
        }
        return clientSecret;
    }
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getPublicClientId() {
        TenantConfig config = this.getCurrentConfig();
        if (null != config) {
            return config.getKcPublicClientId();
        }
        return publicClientId;
    }
    public void setPublicClientId(String publicClientId) {
        this.publicClientId = publicClientId;
    }

    public String getSecureUris() {
        TenantConfig config = this.getCurrentConfig();
        if (null != config) {
            return config.getKcSecureUris();
        }
        return secureUris;
    }
    public void setSecureUris(String secureUris) {
        this.secureUris = secureUris;
    }

    public String getDefaultAuthorizations() {
        TenantConfig config = this.getCurrentConfig();
        if (null != config) {
            return config.getKcDefaultAuthorizations();
        }
        return defaultAuthorizations;
    }
    public void setDefaultAuthorizations(String defaultAuthorizations) {
        this.defaultAuthorizations = defaultAuthorizations;
    }
    
    protected TenantConfig getCurrentConfig() {
        String tenantCode = (String) EntThreadLocal.get(ITenantManager.THREAD_LOCAL_TENANT_CODE);
        if (!StringUtils.isBlank(tenantCode)) {
            return this.getTenantManager().getConfig(tenantCode);
        }
        return null;
    }
    protected ITenantManager getTenantManager() {
        return tenantManager;
    }
    @Autowired
    public void setTenantManager(ITenantManager tenantManager) {
        this.tenantManager = tenantManager;
    }

}
