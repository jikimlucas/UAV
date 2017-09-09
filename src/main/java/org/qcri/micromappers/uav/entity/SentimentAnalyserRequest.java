package org.qcri.micromappers.uav.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by jlucas on 2/17/17.
 */
@Entity
@Table(name = "sentiment_analyser_request")
public class SentimentAnalyserRequest extends ExtendedBaseEntity {
    private static final long serialVersionUID = -881973526366597368L;

    @Column(name="state")
    String state;

    @Column(name="collection_Id", nullable = false)
    Long collectionId;

    @Column(length = 250, name="feed_path", nullable = false)
    private String feedPath;

    public SentimentAnalyserRequest() {
    }

    public SentimentAnalyserRequest(String state, String feedPath, long collectionId) {
        this.state = state;
        this.feedPath = feedPath;
        this.collectionId = collectionId;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFeedPath() {
        return feedPath;
    }

    public void setFeedPath(String feedPath) {
        this.feedPath = feedPath;
    }
}
