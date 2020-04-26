import React from "react";
import { Menu } from "antd";
import { Icon } from "mouse-an";
import { menus as menusData } from "../../common/menus";
const { SubMenu } = Menu;
import history from "../../utils/history";
export default () => {
	/**
	 * 点击菜单
	 */
	const clickMenu = ({ item }) => {
		const { props } = item || {};
		const { path } = props || {};
		path ? history.push(path) : console.warn("跳转路径为空");
	};

	const renderMenus = (menus = menusData) => {
		if (menus.length) {
			return menus.map(({ id, title, path, children, icon }) => {
				if ((children || []).length) {
					return (
						<SubMenu
							key={id}
							title={
								<span>
									<Icon type={icon} />
									<span>{title}</span>
								</span>
							}
						>
							{renderMenus(children)}
						</SubMenu>
					);
				} else {
					return (
						<Menu.Item key={id} path={path}>
							<Icon type={icon} />
							<span>{title}</span>
						</Menu.Item>
					);
				}
			});
		}
	};
	return (
		<Menu style={{ width: 200 }} mode="inline" onClick={clickMenu}>
			{renderMenus()}
		</Menu>
	);
};
