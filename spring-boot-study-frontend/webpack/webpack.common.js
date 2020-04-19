const webpack = require("webpack");
const path = require("path");
const HtmlWebpackPlugin = require("html-webpack-plugin");

module.exports = {
	entry: {
		fc: "./src/index.js",
	},
	output: {
		filename: "[name].[hash].js",
		path: path.resolve(__dirname, "../dist/public"),
		publicPath: "/",
	},
	resolve: {
		extensions: [".js", ".jsx", ".vue", ".json"],
		alias: {
			"@": path.join(__dirname, "..", "src"),
		},
	},
	plugins: [
		new webpack.ProgressPlugin(),
		new HtmlWebpackPlugin({
			inject: true, // will inject the main bundle to index.html
			template: path.resolve(__dirname, "../public/index.html"),
			favicon: path.resolve(__dirname, "../src/images/logo.svg"),
			title: "Mouse Demo",
			filename: "index.html",
		}),
	],
	module: {
		rules: [
			{
				test: /\.(js|jsx)$/,
				use: [
					{
						loader: "eslint-loader",
						options: {
							// 这里的配置项参数将会被传递到 eslint 的 CLIEngine
							formatter: require("eslint-friendly-formatter"), // 指定错误报告的格式规范
						},
					},
				],
				enforce: "pre", // 编译前检查
				exclude: /node_modules/, // 不检测的文件
				include: [path.resolve(__dirname, "../src")], // 指定检查的目录
			},
			{
				test: /\.(js|jsx|mjs)$/,
				exclude: /node_modules/,
				loader: "babel-loader",
			},
			{
				test: /\.(png|jpg|gif)$/,
				use: ["file-loader"],
			},
			{
				test: /\.(woff|woff2|eot|ttf|otf)$/,
				use: ["file-loader"],
			},
			{
				test: /\.svg(\?v=\d+\.\d+\.\d+)?$/,
				use: [
					{
						loader: "babel-loader",
					},
					{
						loader: "@svgr/webpack",
						options: {
							babel: false,
							icon: true,
						},
					},
				],
			},
			// 设置less开启样式模块化
			{
				test: /\.less$/,
				use: [
					"style-loader",
					{
						loader: "css-loader",
						options: {
							modules: true,
						},
					},
					{ loader: "less-loader" },
				],
			},
			// 这里设置css开启modules支持,node_modules和antd里面的css不开启
			{
				test: /\.css$/,
				exclude: /node_modules|antd\.css|global.css/,
				use: [
					"style-loader",
					{
						loader: require.resolve("css-loader"),
						options: {
							importLoaders: 1,
							// 改动
							modules: true, // 新增对css modules的支持
							localIndetName: "[name]__[local]__[hash:base64:5]", //
						},
					},
				],
			},
			// 针对node_modules和antd里面的css写编译配置
			{
				test: /\.css$/,
				include: /node_modules|antd\.css|global.css/,
				use: [
					"style-loader",
					{
						loader: require.resolve("css-loader"),
						options: {
							importLoaders: 1,
						},
					},
				],
			},
		],
	},
};
