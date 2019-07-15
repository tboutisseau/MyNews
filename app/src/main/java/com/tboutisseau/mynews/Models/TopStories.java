package com.tboutisseau.mynews.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public abstract class TopStories {

    @Expose
    @SerializedName("results")
    private List<Results> results;
    @Expose
    @SerializedName("num_results")
    private int num_results;
    @Expose
    @SerializedName("last_updated")
    private String last_updated;
    @Expose
    @SerializedName("section")
    private String section;
    @Expose
    @SerializedName("copyright")
    private String copyright;
    @Expose
    @SerializedName("status")
    private String status;

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public int getNum_results() {
        return num_results;
    }

    public void setNum_results(int num_results) {
        this.num_results = num_results;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class Results {
        @Expose
        @SerializedName("short_url")
        private String short_url;
        @Expose
        @SerializedName("multimedia")
        private List<Multimedia> multimedia;
        @Expose
        @SerializedName("geo_facet")
        private List<String> geo_facet;
        @Expose
        @SerializedName("per_facet")
        private List<String> per_facet;
        @Expose
        @SerializedName("org_facet")
        private List<String> org_facet;
        @Expose
        @SerializedName("des_facet")
        private List<String> des_facet;
        @Expose
        @SerializedName("kicker")
        private String kicker;
        @Expose
        @SerializedName("material_type_facet")
        private String material_type_facet;
        @Expose
        @SerializedName("published_date")
        private String published_date;
        @Expose
        @SerializedName("created_date")
        private String created_date;
        @Expose
        @SerializedName("updated_date")
        private String updated_date;
        @Expose
        @SerializedName("item_type")
        private String item_type;
        @Expose
        @SerializedName("byline")
        private String byline;
        @Expose
        @SerializedName("url")
        private String url;
        @Expose
        @SerializedName("title")
        private String title;
        @Expose
        @SerializedName("subsection")
        private String subsection;
        @Expose
        @SerializedName("section")
        private String section;

        public String getShort_url() {
            return short_url;
        }

        public void setShort_url(String short_url) {
            this.short_url = short_url;
        }

        public List<Multimedia> getMultimedia() {
            return multimedia;
        }

        public void setMultimedia(List<Multimedia> multimedia) {
            this.multimedia = multimedia;
        }

        public List<String> getGeo_facet() {
            return geo_facet;
        }

        public void setGeo_facet(List<String> geo_facet) {
            this.geo_facet = geo_facet;
        }

        public List<String> getPer_facet() {
            return per_facet;
        }

        public void setPer_facet(List<String> per_facet) {
            this.per_facet = per_facet;
        }

        public List<String> getOrg_facet() {
            return org_facet;
        }

        public void setOrg_facet(List<String> org_facet) {
            this.org_facet = org_facet;
        }

        public List<String> getDes_facet() {
            return des_facet;
        }

        public void setDes_facet(List<String> des_facet) {
            this.des_facet = des_facet;
        }

        public String getKicker() {
            return kicker;
        }

        public void setKicker(String kicker) {
            this.kicker = kicker;
        }

        public String getMaterial_type_facet() {
            return material_type_facet;
        }

        public void setMaterial_type_facet(String material_type_facet) {
            this.material_type_facet = material_type_facet;
        }

        public String getPublished_date() {
            return published_date;
        }

        public void setPublished_date(String published_date) {
            this.published_date = published_date;
        }

        public String getCreated_date() {
            return created_date;
        }

        public void setCreated_date(String created_date) {
            this.created_date = created_date;
        }

        public String getUpdated_date() {
            return updated_date;
        }

        public void setUpdated_date(String updated_date) {
            this.updated_date = updated_date;
        }

        public String getItem_type() {
            return item_type;
        }

        public void setItem_type(String item_type) {
            this.item_type = item_type;
        }

        public String getByline() {
            return byline;
        }

        public void setByline(String byline) {
            this.byline = byline;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubsection() {
            return subsection;
        }

        public void setSubsection(String subsection) {
            this.subsection = subsection;
        }

        public String getSection() {
            return section;
        }

        public void setSection(String section) {
            this.section = section;
        }
    }

    public static class Multimedia {
        @Expose
        @SerializedName("copyright")
        private String copyright;
        @Expose
        @SerializedName("caption")
        private String caption;
        @Expose
        @SerializedName("subtype")
        private String subtype;
        @Expose
        @SerializedName("type")
        private String type;
        @Expose
        @SerializedName("width")
        private int width;
        @Expose
        @SerializedName("height")
        private int height;
        @Expose
        @SerializedName("format")
        private String format;
        @Expose
        @SerializedName("url")
        private String url;

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
