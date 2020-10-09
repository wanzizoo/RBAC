package cn.wanzizoo.rbac.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private Long id;

    private String name;

    private String password;

    private String email;

    private Integer age;

    private Boolean admin;

    private Long dept_id;

}