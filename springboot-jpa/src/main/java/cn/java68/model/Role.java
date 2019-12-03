package cn.java68.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_role")
public class Role {

    @Id
    @Column(name = "id",length = 128)
    private Integer id;

    @Column(name = "role_name",length = 255)
    private String roleName;
}
