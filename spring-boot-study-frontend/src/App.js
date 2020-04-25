import { ConfigProvider } from "antd";
import zhCN from "antd/lib/locale-provider/zh_CN";
import React from "react";
import { Router, Route, Switch } from "react-router-dom";
import asyncComponent from "./utils/AsyncComponent";
import history from "./utils/history";
import "./components/index.css";
const App = () => {
	const basicLayout = asyncComponent(() => import("./layout/BasicLayout"));
	return (
		<ConfigProvider locale={zhCN}>
			<Router history={history}>
				<Switch>
					{/* <Route path="/" component={basicLayout}></Route> */}
					<Route path="/" component={basicLayout}></Route>
				</Switch>
			</Router>
		</ConfigProvider>
	);
};

export default App;
