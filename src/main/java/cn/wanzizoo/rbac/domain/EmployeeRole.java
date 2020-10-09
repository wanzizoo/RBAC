package cn.wanzizoo.rbac.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeRole {
    private Long employee_id;

    private Long role_id;

}