package com.adobe.training.summit.core.models;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.via.ResourceSuperType;

import com.adobe.cq.wcm.core.components.models.List;
import com.adobe.cq.wcm.core.components.models.ListItem;
import com.day.cq.wcm.api.Page;

@Model(adaptables = SlingHttpServletRequest.class, adapters = List.class, resourceType = "summit/components/content/list")
public class SpeakerList implements List {

    @Self
    @Via(type = ResourceSuperType.class)
    private List list;

    @SlingObject
    private ResourceResolver resourceResolver;

    @Override
    public Collection<ListItem> getListItems() {
        Collection<ListItem> listItems = new ArrayList<>();
        for (ListItem item : list.getListItems()) {
            listItems.add(new SpeakerListItem(item));
        }
        return listItems;
    }

    @Override
    public boolean linkItems() {
        return list.linkItems();
    }

    public class SpeakerListItem implements ListItem {

        ListItem item;
        private String subTitle;
        private String imageSrc;

        SpeakerListItem(ListItem item) {
            this.item = item;
            //TODO: Add implemntation to populate the subtitle and image source
        }

        public String getSubTitle() {
            return subTitle;
        }

        public String getImageSrc() {
            return imageSrc;
        }

        @Override
        public String getTitle() {
            return item.getTitle();
        }

        @Override
        public String getDescription() {
            return item.getDescription();
        }

        @Override
        public String getURL() {
            return item.getURL();
        }
    }
}
