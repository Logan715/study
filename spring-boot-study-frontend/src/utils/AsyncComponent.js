/**
 * 异步组件
 **/

import React, { Component } from "react";

export default function asyncComponent(importComponent, n = {}) {
	class AsyncComponent extends Component {
		constructor(props) {
			super(props);
			this.state = {
				component: null,
			};
		}

		async componentDidMount() {
			const { default: component } = await importComponent();
			this.setState({
				component: component,
			});
		}

		render() {
			const C = this.state.component;
			// 这里不写null的话，可以提供一个菊花图，表示组件正在渲染
			return C ? <C {...this.props} {...n} /> : null;
		}
	}
	return AsyncComponent;
}
