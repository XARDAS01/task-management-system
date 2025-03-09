package org.example.api.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public record MultiIdRequest<T>(@NotNull @Size(min = 1) List<@NotNull T> data) {

}
