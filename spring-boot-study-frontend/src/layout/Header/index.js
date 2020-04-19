import React from "react";
import Logo from "../../images/logo.svg";
export default () => {
	return (
		<div className="mouse-layout-header">
			<div className={"mouse-layout-header-logo"}>
				<span>
					<Logo width={40} height={40}></Logo>
				</span>
				<span>DEMO</span>
			</div>
			<div className="mouse-layout-header-content">练习界面</div>
			{/* <div>3</div> */}
		</div>
	);
};
