package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.TitleModel;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.commons.link.Link;
import com.adobe.cq.wcm.core.components.models.Title;
import com.adobe.cq.wcm.core.components.models.datalayer.ComponentData;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.via.ResourceSuperType;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {
                TitleModel.class,
                Title.class,
                ComponentExporter.class
        },
        resourceType = {TitleModelImpl.TITLE_RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(
        name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
        extensions = ExporterConstants.SLING_MODEL_EXTENSION)
@JsonSerialize(as = TitleModelImpl.class)
public class TitleModelImpl implements TitleModel {

    public static final String TITLE_RESOURCE_TYPE = "wknd/components/title";

    @Self
    @Via(type = ResourceSuperType.class)
    private Title delegate;

    @Override
    public String getText() {
        return delegate.getText();
    }

    @Override
    public String getType() {
        return delegate.getType();
    }

    @Override
    public Link getLink() {
        return delegate.getLink();
    }

    @Override
    public String getLinkURL() {
        return delegate.getLinkURL();
    }

    @Override
    public boolean isLinkDisabled() {
        return delegate.isLinkDisabled();
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
    public String getAppliedCssClasses() {
        return delegate.getAppliedCssClasses();
    }

    @Override
    public String getExportedType() {
        return TITLE_RESOURCE_TYPE;
    }
}
