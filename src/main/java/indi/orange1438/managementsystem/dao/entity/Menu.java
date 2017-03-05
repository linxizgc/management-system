/* https://github.com/orange1438 */
package indi.orange1438.managementsystem.dao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单表 sys_menu
 *
 * @author orange1438 code generator
 */
public class Menu implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = -8275409334192316352L;

    // 菜单ID
    private Long menuId;

    // 菜单名称
    private String menuName;

    // 菜单URL
    private String menuUrl;

    // 父菜单ID
    private Long parentId;

    // 菜单图标名
    private String menuIcon;

    // 排序  默认：0
    private Integer order;

    // 创建时间  默认：CURRENT_TIMESTAMP
    private Date createTime;

    // 创建人
    private String creater;

    // 修改时间  默认：CURRENT_TIMESTAMP
    private Date modifyTime;

    // 修改人
    private String modifier;

    /**
     * 获取 菜单ID sys_menu.MENU_ID
     *
     * @return 菜单ID
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 设置 菜单ID sys_menu.MENU_ID
     *
     * @param menuId 菜单ID
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取 菜单名称 sys_menu.MENU_NAME
     *
     * @return 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置 菜单名称 sys_menu.MENU_NAME
     *
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * 获取 菜单URL sys_menu.MENU_URL
     *
     * @return 菜单URL
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * 设置 菜单URL sys_menu.MENU_URL
     *
     * @param menuUrl 菜单URL
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    /**
     * 获取 父菜单ID sys_menu.PARENT_ID
     *
     * @return 父菜单ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置 父菜单ID sys_menu.PARENT_ID
     *
     * @param parentId 父菜单ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取 菜单图标名 sys_menu.MENU_ICON
     *
     * @return 菜单图标名
     */
    public String getMenuIcon() {
        return menuIcon;
    }

    /**
     * 设置 菜单图标名 sys_menu.MENU_ICON
     *
     * @param menuIcon 菜单图标名
     */
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    /**
     * 获取 排序 sys_menu.ORDER
     *
     * @return 排序
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * 设置 排序 sys_menu.ORDER
     *
     * @param order 排序
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * 获取 创建时间 sys_menu.CREATE_TIME
     *
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 sys_menu.CREATE_TIME
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 创建人 sys_menu.CREATER
     *
     * @return 创建人
     */
    public String getCreater() {
        return creater;
    }

    /**
     * 设置 创建人 sys_menu.CREATER
     *
     * @param creater 创建人
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * 获取 修改时间 sys_menu.MODIFY_TIME
     *
     * @return 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置 修改时间 sys_menu.MODIFY_TIME
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取 修改人 sys_menu.MODIFIER
     *
     * @return 修改人
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置 修改人 sys_menu.MODIFIER
     *
     * @param modifier 修改人
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", menuId=").append(menuId);
        sb.append(", menuName=").append(menuName);
        sb.append(", menuUrl=").append(menuUrl);
        sb.append(", parentId=").append(parentId);
        sb.append(", menuIcon=").append(menuIcon);
        sb.append(", order=").append(order);
        sb.append(", createTime=").append(createTime);
        sb.append(", creater=").append(creater);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifier=").append(modifier);
        sb.append("]");
        return sb.toString();
    }
}