package org.qcri.micromappers.uav.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by jlucas on 2/17/17.
 */
@Entity
@Table(name = "sentiment_analysis")
public class SentimentAnalysis extends ExtendedBaseEntity {
    private static final long serialVersionUID = -881973526366597368L;

    @Column(name="state")
    String state;

    @Column(name="positive",precision = 20, scale =20)
    BigDecimal positive;

    @Column(name="negative",precision = 20, scale =20)
    BigDecimal negative;

    @Column(length = 50, name="feed_id", nullable = false)
    private String feedId;

    @Column(length = 100, name="feed_path", nullable = false)
    private String feedPath;

    @Column(length = 500, name="feed_text")
    private String feedText;

    @Column(name="collection_Id")
    Long collectionId;

    public SentimentAnalysis() {
    }

    public SentimentAnalysis(String state, BigDecimal positive, BigDecimal negative, String feedId, String feedPath, long collectionId) {
        this.state = state;
        this.positive = positive;
        this.negative = negative;
        this.feedId = feedId;
        this.feedPath = feedPath;
        this.collectionId = collectionId;

    }

    public String getFeedText() {
        return feedText;
    }

    public void setFeedText(String feedText) {
        this.feedText = feedText;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public String getFeedPath() {
        return feedPath;
    }

    public void setFeedPath(String feedPath) {
        this.feedPath = feedPath;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getPositive() {
        return positive;
    }

    public void setPositive(BigDecimal positive) {
        this.positive = positive;
    }

    public BigDecimal getNegative() {
        return negative;
    }

    public void setNegative(BigDecimal negative) {
        this.negative = negative;
    }

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId;
    }
}
