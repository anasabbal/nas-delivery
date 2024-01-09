package com.nas.deliv.userservice.dto;



import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseDto {
    protected String id;
    private Integer version;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    protected Boolean deleted;
    protected Boolean active;
}
