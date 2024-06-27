package com.adobe.aem.guides.wknd.core.models;

import com.adobe.cq.wcm.core.components.models.LayoutContainer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(
        value = {"layout", "allowedComponents", "dataLayer"})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public interface ZendeskContainer extends LayoutContainer {
}
