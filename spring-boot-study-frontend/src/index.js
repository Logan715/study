import React from "react";
import ReactDom from "react-dom";
import { Provider } from "react-redux";
import "antd/dist/antd.css";
import store from "./store";
import "./common/global.less";
import "./common/global.css";
import App from "./App";
ReactDom.render(
	<Provider store={store}>
		{/* <BasicLayout></BasicLayout> */}
		<App></App>
	</Provider>,
	document.getElementById("app")
);
