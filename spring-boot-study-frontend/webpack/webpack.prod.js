const merge = require("webpack-merge");
const common = require("./webpack.common.js");
const AutoDllPlugin = require("autodll-webpack-plugin");
const { CleanWebpackPlugin } = require("clean-webpack-plugin");
module.exports = merge(common, {
	performance: {
		hints: false,
	},
	plugins: [
		new CleanWebpackPlugin({
			cleanOnceBeforeBuildPatterns: ["**/*", "!dll", "!dll/vendor*.js"],
		}),
		new AutoDllPlugin({
			inject: true, // will inject the DLL bundle to index.html
			debug: true,
			filename: "[name]_[hash].js",
			path: "./dll",
			entry: {
				vendor: [
					"react",
					"react-dom",
					"redux",
					"redux-thunk",
					"react-redux",
					"react-router-dom",
					"@antv/g2",
					"@antv/g6",
					// "bizcharts",
					// "echarts",
					// "echarts-for-react",
					"antd",
				],
			},
		}),
	],
	mode: "production",
});
