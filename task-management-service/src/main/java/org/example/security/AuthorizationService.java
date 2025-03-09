package org.example.security;

import java.util.UUID;

public interface AuthorizationService {

    boolean isTaskOwner(UUID taskId);
}
