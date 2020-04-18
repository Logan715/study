import React from "react";
import ReactDom from "react-dom";
import { Provider } from "react-redux";
import "antd/dist/antd.css";
import store from "./store";

ReactDom.render(
	<Provider store={store}>
		<div> hello world </div>
	</Provider>,
	document.getElementById("app")
);
