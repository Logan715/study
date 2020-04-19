import React from "react";
import { Menu, Icon } from "antd";
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
			{/* <SubMenu
				key="sub1"
				title={
					<span>
						<Icon type="mail" />
						<span>Navigation One</span>
					</span>
				}
			>
				<Menu.ItemGroup key="g1" title="Item 1">
					<Menu.Item key="1">Option 1</Menu.Item>
					<Menu.Item key="2">Option 2</Menu.Item>
				</Menu.ItemGroup>
				<Menu.ItemGroup key="g2" title="Item 2">
					<Menu.Item key="3">Option 3</Menu.Item>
					<Menu.Item key="4">Option 4</Menu.Item>
				</Menu.ItemGroup>
			</SubMenu>
			<SubMenu
				key="sub2"
				title={
					<span>
						<Icon type="appstore" />
						<span>Navigation Two</span>
					</span>
				}
			>
				<Menu.Item key="5">Option 5</Menu.Item>
				<Menu.Item key="6">Option 6</Menu.Item>
				<SubMenu key="sub3" title="Submenu">
					<Menu.Item key="7">Option 7</Menu.Item>
					<Menu.Item key="8">Option 8</Menu.Item>
				</SubMenu>
			</SubMenu>
			<SubMenu
				key="sub4"
				title={
					<span>
						<Icon type="setting" />
						<span>Navigation Three</span>
					</span>
				}
			>
				<Menu.Item key="9">Option 9</Menu.Item>
				<Menu.Item key="10">Option 10</Menu.Item>
				<Menu.Item key="11">Option 11</Menu.Item>
				<Menu.Item key="12">Option 12</Menu.Item>
			</SubMenu> */}
		</Menu>
	);
};
