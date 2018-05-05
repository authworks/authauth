package io.securera.authauth.model;

import javax.persistence.*;

@Entity
@Table(name = "journal")
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String action; // ISSUE / REFRESH / REVOKE / EXCHANGE
    @Column(name = "access_token")
    private String accessToken;
    @Column(name = "non_access_token")
    private String nonAccessToken;
    @Column(name = "occurred_at")
    private String occurredAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getNonAccessToken() {
        return nonAccessToken;
    }

    public void setNonAccessToken(String nonAccessToken) {
        this.nonAccessToken = nonAccessToken;
    }

    public String getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(String occurredAt) {
        this.occurredAt = occurredAt;
    }
}
