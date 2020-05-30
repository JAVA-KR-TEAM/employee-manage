package com.employee.app.Member.domain;

import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
@Getter
@RequiredArgsConstructor
public class Member {
    private final Id id;
    private final Name name;
    private final Email email;
    private final Phone phone;
    private final Rank rank;
}
