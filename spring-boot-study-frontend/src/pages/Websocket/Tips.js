import React from "react";
import { PageTip } from "mouse-an";
export default () => {
	return (
		<React.Fragment>
			<PageTip>
				1. 界面上有三种websocket消息
				<br />
				&nbsp;&nbsp;1.1 连接websocket,定时1秒钟websocket往
				<code>/topic/sysTime</code>
				发送系统时间
				<br />
				&nbsp;&nbsp;1.2. 连接websocket,定时2秒钟websocket往
				<code>/mouse/logan/sysTime</code>
				指定的用户<code>logan</code>发送系统时间
				<br />
				&nbsp;&nbsp;1.3. 连接websocket,往服务器发送<code>姓名</code>
				,服务器返回hello,姓名
			</PageTip>
			<PageTip>2. 定时任务的基本使用 @EnableScheduling 和 @Scheduled</PageTip>
		</React.Fragment>
	);
};
