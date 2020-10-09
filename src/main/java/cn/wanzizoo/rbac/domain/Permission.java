package cn.wanzizoo.rbac.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Permission {
    private Long id;

    private String name;

    private String expression;

}