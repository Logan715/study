import asyncComponent from "../utils/AsyncComponent";
class RouterUtils {
	constructor() {
		this.router = {};
	}

	/**
	 * 路由配置文件
	 * breadName，数组结构，包含对象和字符串。
	 * 对象： {name,path} name显示的名称，path跳转的路由
	 * 字符串： 显示的的内容
	 */
	getRouter = () => {
		let routers = [
			{
				path: "/websocket",
				component: asyncComponent(() => import("../pages/Websocket")),
			},
			{
				path: "/event",
				component: asyncComponent(() => import("../pages/ApplicationEvent")),
			},
		];

		return routers;
	};
}

export default new RouterUtils();
