import React from "react";
import Header from "./Header";
import Menus from "./Menus";
import Pages from "./Pages";
export default () => {
	return (
		<div className="mouse-layout">
			<Header></Header>
			<div className="mouse-layout-content">
				<Menus></Menus>
				<Pages></Pages>
			</div>
		</div>
	);
};
