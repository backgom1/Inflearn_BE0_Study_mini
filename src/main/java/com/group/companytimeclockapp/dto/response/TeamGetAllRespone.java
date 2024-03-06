package com.group.companytimeclockapp.dto.response;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class TeamGetAllRespone {
    private final String name;
    private final List<String> manager;
    private final Integer memberCount;
}
