import React from "react";
import RouterUtils from "../../common/RouterUtils";
const pageComponents = RouterUtils.getRouter();
import { Switch, Route, Redirect } from "react-router-dom";
export default () => {
	return (
		<div className="mouse-layout-pages">
			<Switch>
				{pageComponents.map(({ path, component }) => (
					<Route key={path} exact path={path} component={component}></Route>
				))}
				<Redirect to="/404" />
			</Switch>
		</div>
	);
};
