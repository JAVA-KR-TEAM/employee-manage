package com.employee.app.Member.domain;

import com.employee.app.dto.MemberDto;
import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
@Getter
@RequiredArgsConstructor
public class Member {
    private Id id;
    private Name name;
    private Email email;
    private Phone phone;
    private Rank rank;

    public Member changeInformation(MemberDto memberDto) {
        this.name = memberDto.getName();
        this.phone = memberDto.getPhone();
        this.email = memberDto.getEmail();
        this.rank = memberDto.getRank();

        return this;
    }
}
