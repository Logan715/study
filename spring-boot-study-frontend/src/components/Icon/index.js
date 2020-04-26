import React from "react";
import IconFont from "./iconfont";
import { useEffect, useState } from "react";
import { Icon } from "antd";
const MouseIcon = ({ type, ...other }) => {
	const prefix = "anticon";
	const [isCustom, setIsCustom] = useState(false);
	useEffect(() => {
		if ((type || "").indexOf("mouse-") == 0) {
			setIsCustom(true);
		} else {
			setIsCustom(false);
		}
	}, []);

	if (isCustom) {
		const CustomIcon = Icon.createFromIconfontCN({
			scriptUrl: IconFont,
			extraCommonProps: other,
		});
		const customType = `${prefix}-${type}`;
		return <CustomIcon type={customType} {...other} />;
	} else {
		return <Icon type={type} {...other} />;
	}
};

export default MouseIcon;
