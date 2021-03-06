/* https://github.com/orange1438 */
package indi.orange1438.managementsystem.dao;

import indi.orange1438.managementsystem.dao.entity.RolePermission;
import indi.orange1438.managementsystem.dao.entity.RolePermissionExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 *
 * @author orange1438 code generator
 */
@Repository
public interface RolePermissionDAO extends IMapper<RolePermission, RolePermissionExample, Long> {

    /**
     * 指定角色是否拥有指定的菜单ID
     *
     * @param roleId 角色ID
     * @param menuId 菜单ID
     * @return
     */
    List<RolePermission> isHaveMenu(@Param("roleId") Long roleId, @Param("menuId") Long menuId);
}