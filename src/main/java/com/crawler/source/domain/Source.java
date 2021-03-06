package com.crawler.source.domain;

public class Source {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column source.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column source.url
     *
     * @mbggenerated
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column source.url_number
     *
     * @mbggenerated
     */
    private Integer urlNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column source.channel
     *
     * @mbggenerated
     */
    private String channel;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column source.id
     *
     * @return the value of source.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column source.id
     *
     * @param id the value for source.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column source.url
     *
     * @return the value of source.url
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column source.url
     *
     * @param url the value for source.url
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column source.url_number
     *
     * @return the value of source.url_number
     *
     * @mbggenerated
     */
    public Integer getUrlNumber() {
        return urlNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column source.url_number
     *
     * @param urlNumber the value for source.url_number
     *
     * @mbggenerated
     */
    public void setUrlNumber(Integer urlNumber) {
        this.urlNumber = urlNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column source.channel
     *
     * @return the value of source.channel
     *
     * @mbggenerated
     */
    public String getChannel() {
        return channel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column source.channel
     *
     * @param channel the value for source.channel
     *
     * @mbggenerated
     */
    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    @Override
    public String toString() {
        return "Source{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", urlNumber=" + urlNumber +
                ", channel='" + channel + '\'' +
                '}';
    }
}