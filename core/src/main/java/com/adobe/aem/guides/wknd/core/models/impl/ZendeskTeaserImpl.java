package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.commons.link.Link;
import com.adobe.cq.wcm.core.components.models.Teaser;
import com.adobe.cq.wcm.core.components.models.datalayer.ComponentData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.adobe.aem.guides.wknd.core.models.ZendeskContainer;
import com.adobe.aem.guides.wknd.core.models.ZendeskTeaser;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.via.ResourceSuperType;
import org.apache.sling.models.factory.ModelFactory;

import javax.annotation.PostConstruct;
import javax.inject.Named;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {
                ZendeskTeaser.class,
                Teaser.class,
                ComponentExporter.class
        },
        resourceType = {"wknd/components/teaser"},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(
        name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
        extensions = ExporterConstants.SLING_MODEL_EXTENSION)
@JsonSerialize(as = ZendeskTeaserImpl.class)
public class ZendeskTeaserImpl implements ZendeskTeaser {
    @Self
    @Via(type = ResourceSuperType.class)
    private Teaser delegate;

    @Self
    private SlingHttpServletRequest request;

    @OSGiService
    private ModelFactory modelFactory;

    @ValueMapValue
    private String fileReference;

    @ChildResource
    @Named("additional-content")
    private Resource additionalContent;

    @PostConstruct
    public void init() {
        System.out.println("test");
    }

    @Override
    public boolean isActionsEnabled() {
        return delegate.isActionsEnabled();
    }

    @Override
    public Link getLink() {
        return delegate.getLink();
    }

    @Override
    public String getLinkURL() {
        return delegate.getLinkURL();
    }

    public String getImagePath() {
        return this.fileReference;
    }

    @Override
    public boolean isImageLinkHidden() {
        return delegate.isImageLinkHidden();
    }

    @Override
    public String getPretitle() {
        return delegate.getPretitle();
    }

    @Override
    public String getTitle() {
        return delegate.getTitle();
    }

    @Override
    public boolean isTitleLinkHidden() {
        return delegate.isTitleLinkHidden();
    }

    @Override
    public String getDescription() {
        return delegate.getDescription();
    }

    @Override
    public String getTitleType() {
        return delegate.getTitleType();
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
        return "wknd/components/teaser";
    }

    @Override
    public Resource getImageResource() {
        return delegate.getImageResource();
    }

    @JsonProperty(value = ":items")
    public ZendeskContainer getAdditionalContent() {
        if (this.additionalContent != null) {
            return modelFactory.getModelFromWrappedRequest(request, additionalContent, ZendeskContainer.class);
        } else  {
            return null;
        }
    }
}
