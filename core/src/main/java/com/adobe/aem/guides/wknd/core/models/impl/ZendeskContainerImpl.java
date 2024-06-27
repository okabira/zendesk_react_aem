package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.models.LayoutContainer;
import com.adobe.cq.wcm.core.components.models.ListItem;
import com.adobe.cq.wcm.core.components.models.datalayer.ComponentData;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.adobe.aem.guides.wknd.core.models.ZendeskContainer;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.via.ResourceSuperType;

import java.util.List;
import java.util.Map;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {
                ZendeskContainer.class,
                LayoutContainer.class,
                ComponentExporter.class
        },
        resourceType = {"wknd/components/container"},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(
        name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
        extensions = ExporterConstants.SLING_MODEL_EXTENSION)
@JsonSerialize(as = ZendeskContainerImpl.class)
public class ZendeskContainerImpl implements ZendeskContainer {

    @Self
    @Via(type = ResourceSuperType.class)
    private LayoutContainer delegate;

    @Override
    public List<ListItem> getItems() {
        return delegate.getItems();
    }

    @Override
    public String getId() {
        return delegate.getId();
    }

    @Override
    public ComponentData getData() {
        return delegate.getData();
    }

    @Override
    public LayoutContainer.LayoutType getLayout() {
        return delegate.getLayout();
    }

    @Override
    public String getAccessibilityLabel() {
        return delegate.getAccessibilityLabel();
    }

    @Override
    public String getExportedType() {
        return "wknd/components/container";
    }

    @Override
    public String getRoleAttribute() {
        return delegate.getRoleAttribute();
    }

    @Override
    public String getBackgroundStyle() {
        return delegate.getBackgroundStyle();
    }

    @Override
    public Map<String, ? extends ComponentExporter> getExportedItems() {
        return delegate.getExportedItems();
    }

    @Override
    public String[] getExportedItemsOrder() {
        return delegate.getExportedItemsOrder();
    }
}
