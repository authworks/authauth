package io.securera.authauth.service;

import io.securera.authauth.model.AccessToken;
import io.securera.authauth.model.AcessTokenType;
import io.securera.authauth.model.Journal;
import io.securera.authauth.repository.AccessTokenRepository;
import io.securera.authauth.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class TokenService {
    @Autowired
    private AccessTokenRepository accessTokenRepository;
    @Autowired
    private JournalRepository journalRepository;

    public AccessToken issueAccessToken(String clientId, String resourceOwnerId, String scope) {
        String token = generate("access_token");
        String now = String.valueOf(new Date().getTime());
        AccessToken accessToken = new AccessToken();
        accessToken.setAccessToken(token);
        accessToken.setClientId(clientId);
        accessToken.setResourceOwnerId(resourceOwnerId);
        accessToken.setScope(scope);
        accessToken.setTokenType(AcessTokenType.Bearer.getValue());
        accessToken.setStatus("normal");
        accessToken.setExpiresIn(3600);
        accessToken.setIssuedAt(now);
        accessTokenRepository.save(accessToken);

        Journal journal = new Journal();
        journal.setAction("issue");
        journal.setAccessToken(token);
        journal.setOccurredAt(now);
        journalRepository.save(journal);

        return accessToken;
    }

    public String issueRefreshToken() {
        return "";
    }

    public String refreshAccessToken() {
        return "";
    }

    public String issueAuthorizationCode() {
        return "";
    }

    private static String generate(String type) {
        ShortUuid.Builder builder = new ShortUuid.Builder();
        ShortUuid shortUuid = builder.build(UUID.randomUUID());

        return shortUuid.toString();
    }

    public static void main(String[] args) {
        System.out.println(generate(""));
    }
}
