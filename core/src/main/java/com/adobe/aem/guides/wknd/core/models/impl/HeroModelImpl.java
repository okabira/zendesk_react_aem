package com.adobe.aem.guides.wknd.core.models.impl;


import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.models.Image;
import com.adobe.cq.wcm.core.components.models.Text;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.adobe.aem.guides.wknd.core.models.HeroModel;
import com.adobe.aem.guides.wknd.core.models.TitleModel;
import com.adobe.aem.guides.wknd.core.models.ZendeskButton;

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

    @PostConstruct
    public void init() {
        System.out.println("HeroModelImpl init");
    }

    public TitleModel getTitle() {
        if (this.title != null) {
            return modelFactory.getModelFromWrappedRequest(request, this.title, TitleModel.class);
        } else  {
            return null;
        }
    }

    public ZendeskButton getButton() {
        if (this.button != null) {
            return modelFactory.getModelFromWrappedRequest(request, this.button, ZendeskButton.class);
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
}
