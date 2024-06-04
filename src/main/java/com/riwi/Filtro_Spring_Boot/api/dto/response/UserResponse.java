package com.riwi.Filtro_Spring_Boot.api.dto.response;

import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long userId;
    private String username;
    private String email;
    private boolean active;
}
