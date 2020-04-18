const merge = require("webpack-merge");
const common = require("./webpack.common.js");
const webpack = require("webpack");
const path = require("path");

const target = "localhost:7070";
module.exports = merge(common, {
	devtool: "inline-source-map",
	devServer: {
		host: "0.0.0.0",
		port: 9030,
		contentBase: path.join(__dirname, "../dist/webapp"),
		publicPath: "/",
		overlay: {
			errors: true,
		},
		// 启动 HMR 热替换
		// 允许在运行时更新各种模块，而无需进行完全刷新
		hot: true,
		inline: true,
		// 处理页面强制刷新时路由页面404问题
		historyApiFallback: true,
		// 配置easymock代理

		proxy: {
			"/proxy": {
				changeOrigin: true,
				target: target,
			},
		},
	},
	plugins: [
		// 热替换
		new webpack.HotModuleReplacementPlugin(),
	],
	mode: "development",
});
