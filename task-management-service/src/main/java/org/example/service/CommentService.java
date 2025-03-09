package org.example.service;

import org.example.api.request.CommentRequest;
import org.example.jpa.domain.DbId;
import org.springframework.lang.NonNull;

import java.util.UUID;

public interface CommentService {

    @NonNull
    DbId<UUID> comment(@NonNull CommentRequest commentRequest);

    void delete(@NonNull UUID id);
}
