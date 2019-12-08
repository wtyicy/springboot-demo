package cn.java68.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "t_role")
public class Role {

    @Id
    @Column(name = "id",length = 128)
    @NotNull(message = "ID不能为空")
    private Integer id;

    @Column(name = "role_name",length = 255)
    @NotNull(message = "角色名称不能为空")
    private String roleName;
}
