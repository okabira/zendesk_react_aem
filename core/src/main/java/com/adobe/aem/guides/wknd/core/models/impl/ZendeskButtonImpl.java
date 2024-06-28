package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.ZendeskButton;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.commons.link.Link;
import com.adobe.cq.wcm.core.components.models.Button;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.via.ResourceSuperType;

@Model(
        adaptables = {Resource.class, SlingHttpServletRequest.class},
        adapters = {
                ZendeskButton.class,
                ComponentExporter.class
        },
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = "wknd/components/button")
@Exporter(
        name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
        extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ZendeskButtonImpl implements ZendeskButton {

    @Self
    @Via(type = ResourceSuperType.class)
    private Button delegate;

    @Override
    public String getText() {
        return delegate.getText();
    }

    @Override
    public Link getButtonLink() {
        return delegate.getButtonLink();
    }

    @Override
    public String getLink() {
        return delegate.getLink();
    }

    @Override
    public String getIcon() {
        return delegate.getIcon();
    }

    @Override
    public String getAccessibilityLabel() {
        return delegate.getAccessibilityLabel();
    }
}
