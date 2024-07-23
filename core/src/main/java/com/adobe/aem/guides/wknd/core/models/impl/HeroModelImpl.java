package com.adobe.aem.guides.wknd.core.models.impl;


import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.models.Image;
import com.adobe.cq.wcm.core.components.models.Text;
import com.adobe.cq.wcm.style.ComponentStyleInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.adobe.aem.guides.wknd.core.models.HeroModel;
import com.adobe.aem.guides.wknd.core.models.TitleModel;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.factory.ModelFactory;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.Optional;


@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {
                HeroModel.class,
                ComponentExporter.class
        },
        resourceType = {HeroModelImpl.HERO_RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(
        name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
        extensions = ExporterConstants.SLING_MODEL_EXTENSION)
@JsonSerialize(as = HeroModelImpl.class)
public class HeroModelImpl implements HeroModel {

    public static final String HERO_RESOURCE_TYPE = "wknd/components/hero";

    @Self
    private SlingHttpServletRequest request;

    @OSGiService
    private ModelFactory modelFactory;

    @ChildResource
    private Resource title;

    @ChildResource
    private Resource button;

    @ChildResource
    private Resource image;

    @ChildResource
    private Resource text;

    @ChildResource
    @Named("additional-content")
    private Resource additionalContent;

    @PostConstruct
    public void init() {
        System.out.println("HeroModelImpl init");
    }

    public String getAppliedCssClasses() {

        return Optional.ofNullable(request.getResource().adaptTo(ComponentStyleInfo.class))
                .map(ComponentStyleInfo::getAppliedCssClasses)
                .filter(StringUtils::isNotBlank)
                .orElse(null);		// Returning null so sling model exporters don't return anything for this property if not configured
    }

    public TitleModel getTitle() {
        if (this.title != null) {
            return modelFactory.getModelFromWrappedRequest(request, this.title, TitleModel.class);
        } else  {
            return null;
        }
    }

    public ComponentExporter getButton() {
        if (this.button != null) {
            return modelFactory.getModelFromWrappedRequest(request, this.button, ComponentExporter.class);
        } else  {
            return null;
        }
    }

    public Image getImage() {
        if (this.image != null) {
            return modelFactory.getModelFromWrappedRequest(request, this.image, Image.class);
        } else  {
            return null;
        }
    }

    public Text getText() {
        if (this.text != null) {
            return modelFactory.getModelFromWrappedRequest(request, this.text, Text.class);
        } else  {
            return null;
        }
    }

    @JsonProperty(value = ":type")
    public String getExportedType() {
        return HERO_RESOURCE_TYPE;
    }

    public ComponentExporter getAdditionalContent() {
        if (this.additionalContent != null) {
            return modelFactory.getModelFromWrappedRequest(request, additionalContent, ComponentExporter.class);
        } else  {
            return null;
        }
    }
}
