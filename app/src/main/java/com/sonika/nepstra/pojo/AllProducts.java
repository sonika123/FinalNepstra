package com.sonika.nepstra.pojo;

import org.json.JSONArray;

import java.io.Serializable;

/**
 * Created by sonika on 9/18/2017.
 */

public class AllProducts implements Serializable {
    Integer id,total_sales,download_limit,download_expiry, shipping_class_id,rating_count,
            parent_id, c_id, i_id, i_position, menu_order, m_id, tag_id;
     String price, name, slug,permalink,date_created,date_created_gmt, date_modified,date_modified_gmt,type,
             status,weight,catalog_visibility,description,short_description,sku,regular_price,sale_price,
             price_html,external_url,button_text,tax_status,tax_class,backorders,length,width, height,
             average_rating,shipping_class,purchase_note, c_name, c_slug,i_date_created, i_date_created_gmt,i_date_modified,
             i_date_modified_gmt, i_src, i_name, i_alt, m_key, m_value, self_href, collection_href, tag_name, tag_slug;
    public static transient JSONArray related_ids, upsell_ids,cross_sell_ids,tags, attributes,default_attributes, variations,
            grouped_products,downloads;
    Boolean featured,date_on_sale_from,date_on_sale_from_gmt,date_on_sale_to,date_on_sale_to_gmt,
            backorders_allowed,on_sale,purchasable,virtual,downloadable,manage_stock,reviews_allowed,
            stock_quantity,in_stock,backordered,sold_individually,shipping_required,
            shipping_taxable;


    public AllProducts() {
    }

    public AllProducts(Integer id, Integer total_sales, Integer download_limit, Integer download_expiry, Integer shipping_class_id, Integer rating_count, Integer parent_id, Integer c_id, Integer i_id, Integer i_position, Integer menu_order, Integer m_id, Integer tag_id, String m_key, String m_value, String price, String name, String slug, String permalink, String date_created, String date_created_gmt, String date_modified, String date_modified_gmt, String type, String status, String weight, String catalog_visibility, String description, String short_description, String sku, String regular_price, String sale_price, String price_html, String external_url, String button_text, Integer tag_id1, String tax_status, String tax_class, String backorders, String length, String width, String height, String shipping_class, String purchase_note, String average_rating, String c_name, String c_slug, String i_date_created, String i_date_created_gmt, String i_date_modified, String i_date_modified_gmt, String i_src, String i_name, String i_alt, String self_href, String collection_href, String tag_name, String tag_slug, JSONArray downloads, JSONArray related_ids, JSONArray upsell_ids, JSONArray cross_sell_ids, JSONArray tags, JSONArray attributes, JSONArray default_attributes, JSONArray variations, JSONArray grouped_products, Boolean featured, Boolean date_on_sale_from, Boolean date_on_sale_from_gmt, Boolean date_on_sale_to, Boolean date_on_sale_to_gmt, Boolean on_sale, Boolean purchasable, Boolean virtual, Boolean downloadable, Boolean manage_stock, Boolean stock_quantity, Boolean in_stock, Boolean backorders_allowed, Boolean backordered, Boolean sold_individually, Boolean shipping_required, Boolean shipping_taxable, Boolean reviews_allowed)
    {
        this.id = id;
        this.total_sales = total_sales;
        this.download_limit = download_limit;
        this.download_expiry = download_expiry;
        this.shipping_class_id = shipping_class_id;
        this.rating_count = rating_count;
        this.parent_id = parent_id;
        this.c_id = c_id;
        this.i_id = i_id;
        this.i_position = i_position;
        this.menu_order = menu_order;
        this.m_id = m_id;
        this.tag_id = tag_id;
        this.price = price;
        this.name = name;
        this.slug = slug;
        this.permalink = permalink;
        this.date_created = date_created;
        this.date_created_gmt = date_created_gmt;
        this.date_modified = date_modified;
        this.date_modified_gmt = date_modified_gmt;
        this.type = type;
        this.status = status;
        this.weight = weight;
        this.catalog_visibility = catalog_visibility;
        this.description = description;
        this.short_description = short_description;
        this.sku = sku;
        this.regular_price = regular_price;
        this.sale_price = sale_price;
        this.price_html = price_html;
        this.external_url = external_url;
        this.button_text = button_text;
        this.tax_status = tax_status;
        this.tax_class = tax_class;
        this.backorders = backorders;
        this.length = length;
        this.width = width;
        this.height = height;
        this.shipping_class = shipping_class;
        this.purchase_note = purchase_note;
        this.c_name = c_name;
        this.c_slug = c_slug;
        this.i_date_created = i_date_created;
        this.i_date_created_gmt = i_date_created_gmt;
        this.i_date_modified = i_date_modified;
        this.i_date_modified_gmt = i_date_modified_gmt;
        this.i_src = i_src;
        this.i_name = i_name;
        this.i_alt = i_alt;
        this.m_key = m_key;
        this.m_value = m_value;
        this.self_href = self_href;
        this.collection_href = collection_href;
        this.tag_name = tag_name;
        this.tag_slug = tag_slug;
        this.related_ids = related_ids;
        this.upsell_ids = upsell_ids;
        this.cross_sell_ids = cross_sell_ids;
        this.tags = tags;
        this.attributes = attributes;
        this.default_attributes = default_attributes;
        this.variations = variations;
        this.grouped_products = grouped_products;
        this.downloads = downloads;
        this.featured = featured;
        this.date_on_sale_from = date_on_sale_from;
        this.date_on_sale_from_gmt = date_on_sale_from_gmt;
        this.date_on_sale_to = date_on_sale_to;
        this.date_on_sale_to_gmt = date_on_sale_to_gmt;
        this.backorders_allowed = backorders_allowed;
        this.on_sale = on_sale;
        this.purchasable = purchasable;
        this.virtual = virtual;
        this.downloadable = downloadable;
        this.manage_stock = manage_stock;
        this.reviews_allowed = reviews_allowed;
        this.stock_quantity = stock_quantity;
        this.in_stock = in_stock;
        this.average_rating = average_rating;
        this.backordered = backordered;
        this.sold_individually = sold_individually;
        this.shipping_required = shipping_required;
        this.shipping_taxable = shipping_taxable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotal_sales() {
        return total_sales;
    }

    public void setTotal_sales(Integer total_sales) {
        this.total_sales = total_sales;
    }

    public Integer getDownload_limit() {
        return download_limit;
    }

    public void setDownload_limit(Integer download_limit) {
        this.download_limit = download_limit;
    }

    public Integer getDownload_expiry() {
        return download_expiry;
    }

    public void setDownload_expiry(Integer download_expiry) {
        this.download_expiry = download_expiry;
    }

    public Integer getShipping_class_id() {
        return shipping_class_id;
    }

    public void setShipping_class_id(Integer shipping_class_id) {
        this.shipping_class_id = shipping_class_id;
    }

    public Integer getRating_count() {
        return rating_count;
    }

    public void setRating_count(Integer rating_count) {
        this.rating_count = rating_count;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public Integer getI_id() {
        return i_id;
    }

    public void setI_id(Integer i_id) {
        this.i_id = i_id;
    }

    public Integer getI_position() {
        return i_position;
    }

    public void setI_position(Integer i_position) {
        this.i_position = i_position;
    }

    public Integer getMenu_order() {
        return menu_order;
    }

    public void setMenu_order(Integer menu_order) {
        this.menu_order = menu_order;
    }

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public Integer getTag_id() {
        return tag_id;
    }

    public void setTag_id(Integer tag_id) {
        this.tag_id = tag_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getDate_created_gmt() {
        return date_created_gmt;
    }

    public void setDate_created_gmt(String date_created_gmt) {
        this.date_created_gmt = date_created_gmt;
    }

    public String getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(String date_modified) {
        this.date_modified = date_modified;
    }

    public String getDate_modified_gmt() {
        return date_modified_gmt;
    }

    public void setDate_modified_gmt(String date_modified_gmt) {
        this.date_modified_gmt = date_modified_gmt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCatalog_visibility() {
        return catalog_visibility;
    }

    public void setCatalog_visibility(String catalog_visibility) {
        this.catalog_visibility = catalog_visibility;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getRegular_price() {
        return regular_price;
    }

    public void setRegular_price(String regular_price) {
        this.regular_price = regular_price;
    }

    public String getSale_price() {
        return sale_price;
    }

    public void setSale_price(String sale_price) {
        this.sale_price = sale_price;
    }

    public String getPrice_html() {
        return price_html;
    }

    public void setPrice_html(String price_html) {
        this.price_html = price_html;
    }

    public String getExternal_url() {
        return external_url;
    }

    public void setExternal_url(String external_url) {
        this.external_url = external_url;
    }

    public String getButton_text() {
        return button_text;
    }

    public void setButton_text(String button_text) {
        this.button_text = button_text;
    }

    public String getTax_status() {
        return tax_status;
    }

    public void setTax_status(String tax_status) {
        this.tax_status = tax_status;
    }

    public String getTax_class() {
        return tax_class;
    }

    public void setTax_class(String tax_class) {
        this.tax_class = tax_class;
    }

    public String getBackorders() {
        return backorders;
    }

    public void setBackorders(String backorders) {
        this.backorders = backorders;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(String average_rating) {
        this.average_rating = average_rating;
    }

    public String getShipping_class() {
        return shipping_class;
    }

    public void setShipping_class(String shipping_class) {
        this.shipping_class = shipping_class;
    }

    public String getPurchase_note() {
        return purchase_note;
    }

    public void setPurchase_note(String purchase_note) {
        this.purchase_note = purchase_note;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_slug() {
        return c_slug;
    }

    public void setC_slug(String c_slug) {
        this.c_slug = c_slug;
    }

    public String getI_date_created() {
        return i_date_created;
    }

    public void setI_date_created(String i_date_created) {
        this.i_date_created = i_date_created;
    }

    public String getI_date_created_gmt() {
        return i_date_created_gmt;
    }

    public void setI_date_created_gmt(String i_date_created_gmt) {
        this.i_date_created_gmt = i_date_created_gmt;
    }

    public String getI_date_modified() {
        return i_date_modified;
    }

    public void setI_date_modified(String i_date_modified) {
        this.i_date_modified = i_date_modified;
    }

    public String getI_date_modified_gmt() {
        return i_date_modified_gmt;
    }

    public void setI_date_modified_gmt(String i_date_modified_gmt) {
        this.i_date_modified_gmt = i_date_modified_gmt;
    }

    public String getI_src() {
        return i_src;
    }

    public void setI_src(String i_src) {
        this.i_src = i_src;
    }

    public String getI_name() {
        return i_name;
    }

    public void setI_name(String i_name) {
        this.i_name = i_name;
    }

    public String getI_alt() {
        return i_alt;
    }

    public void setI_alt(String i_alt) {
        this.i_alt = i_alt;
    }

    public String getM_key() {
        return m_key;
    }

    public void setM_key(String m_key) {
        this.m_key = m_key;
    }

    public String getM_value() {
        return m_value;
    }

    public void setM_value(String m_value) {
        this.m_value = m_value;
    }

    public String getSelf_href() {
        return self_href;
    }

    public void setSelf_href(String self_href) {
        this.self_href = self_href;
    }

    public String getCollection_href() {
        return collection_href;
    }

    public void setCollection_href(String collection_href) {
        this.collection_href = collection_href;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public String getTag_slug() {
        return tag_slug;
    }

    public void setTag_slug(String tag_slug) {
        this.tag_slug = tag_slug;
    }

    public JSONArray getRelated_ids() {
        return related_ids;
    }

    public void setRelated_ids(JSONArray related_ids) {
        this.related_ids = related_ids;
    }

    public JSONArray getUpsell_ids() {
        return upsell_ids;
    }

    public void setUpsell_ids(JSONArray upsell_ids) {
        this.upsell_ids = upsell_ids;
    }

    public JSONArray getCross_sell_ids() {
        return cross_sell_ids;
    }

    public void setCross_sell_ids(JSONArray cross_sell_ids) {
        this.cross_sell_ids = cross_sell_ids;
    }

    public JSONArray getTags() {
        return tags;
    }

    public void setTags(JSONArray tags) {
        this.tags = tags;
    }

    public JSONArray getAttributes() {
        return attributes;
    }

    public void setAttributes(JSONArray attributes) {
        this.attributes = attributes;
    }

    public JSONArray getDefault_attributes() {
        return default_attributes;
    }

    public void setDefault_attributes(JSONArray default_attributes) {
        this.default_attributes = default_attributes;
    }

    public JSONArray getVariations() {
        return variations;
    }

    public void setVariations(JSONArray variations) {
        this.variations = variations;
    }

    public JSONArray getGrouped_products() {
        return grouped_products;
    }

    public void setGrouped_products(JSONArray grouped_products) {
        this.grouped_products = grouped_products;
    }

    public JSONArray getDownloads() {
        return downloads;
    }

    public void setDownloads(JSONArray downloads) {
        this.downloads = downloads;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public Boolean getDate_on_sale_from() {
        return date_on_sale_from;
    }

    public void setDate_on_sale_from(Boolean date_on_sale_from) {
        this.date_on_sale_from = date_on_sale_from;
    }

    public Boolean getDate_on_sale_from_gmt() {
        return date_on_sale_from_gmt;
    }

    public void setDate_on_sale_from_gmt(Boolean date_on_sale_from_gmt) {
        this.date_on_sale_from_gmt = date_on_sale_from_gmt;
    }

    public Boolean getDate_on_sale_to() {
        return date_on_sale_to;
    }

    public void setDate_on_sale_to(Boolean date_on_sale_to) {
        this.date_on_sale_to = date_on_sale_to;
    }

    public Boolean getDate_on_sale_to_gmt() {
        return date_on_sale_to_gmt;
    }

    public void setDate_on_sale_to_gmt(Boolean date_on_sale_to_gmt) {
        this.date_on_sale_to_gmt = date_on_sale_to_gmt;
    }

    public Boolean getBackorders_allowed() {
        return backorders_allowed;
    }

    public void setBackorders_allowed(Boolean backorders_allowed) {
        this.backorders_allowed = backorders_allowed;
    }

    public Boolean getOn_sale() {
        return on_sale;
    }

    public void setOn_sale(Boolean on_sale) {
        this.on_sale = on_sale;
    }

    public Boolean getPurchasable() {
        return purchasable;
    }

    public void setPurchasable(Boolean purchasable) {
        this.purchasable = purchasable;
    }

    public Boolean getVirtual() {
        return virtual;
    }

    public void setVirtual(Boolean virtual) {
        this.virtual = virtual;
    }

    public Boolean getDownloadable() {
        return downloadable;
    }

    public void setDownloadable(Boolean downloadable) {
        this.downloadable = downloadable;
    }

    public Boolean getManage_stock() {
        return manage_stock;
    }

    public void setManage_stock(Boolean manage_stock) {
        this.manage_stock = manage_stock;
    }

    public Boolean getReviews_allowed() {
        return reviews_allowed;
    }

    public void setReviews_allowed(Boolean reviews_allowed) {
        this.reviews_allowed = reviews_allowed;
    }

    public Boolean getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(Boolean stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public Boolean getIn_stock() {
        return in_stock;
    }

    public void setIn_stock(Boolean in_stock) {
        this.in_stock = in_stock;
    }

    public Boolean getBackordered() {
        return backordered;
    }

    public void setBackordered(Boolean backordered) {
        this.backordered = backordered;
    }

    public Boolean getSold_individually() {
        return sold_individually;
    }

    public void setSold_individually(Boolean sold_individually) {
        this.sold_individually = sold_individually;
    }

    public Boolean getShipping_required() {
        return shipping_required;
    }

    public void setShipping_required(Boolean shipping_required) {
        this.shipping_required = shipping_required;
    }

    public Boolean getShipping_taxable() {
        return shipping_taxable;
    }

    public void setShipping_taxable(Boolean shipping_taxable) {
        this.shipping_taxable = shipping_taxable;
    }
}