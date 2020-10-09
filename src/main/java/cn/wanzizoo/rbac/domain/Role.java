package cn.wanzizoo.rbac.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role {
    private Long id;

    private String name;

    private String sn;

}