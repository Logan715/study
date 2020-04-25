import React, { useState } from "react";
import { Row, Col, Button, Input } from "antd";
import Stomp from "stomp-websocket";
import SockJS from "sockjs-client";
import { PageTip } from "mouse-an";
import { connect, disconnect } from "../../utils/websocktUtil";
export default () => {
	const [connected, setConnected] = useState(false);
	const [client, setClient] = useState();
	const [response, setResponse] = useState();
	const [name, setName] = useState();
	const [sysTime, setSysTime] = useState();
	const [sysTime2, setSysTime2] = useState();
	const connectWebsocket = () => {
		let subscribe = {};
		subscribe["/topic/greetings"] = ({ body }) => setResponse(body);
		subscribe["/topic/sysTime"] = ({ body: sysTime }) => setSysTime(sysTime);
		subscribe["/mouse/logan/sysTime"] = ({ body: sysTime }) =>
			setSysTime2(sysTime);
		const success = (stompClient) => {
			setConnected(true);
			setClient(stompClient);
		};
		connect("http://localhost:7070/ws", { subscribe, success });
	};

	const disconnectWebsocket = () => {
		disconnect(client);
		setConnected(false);
	};

	const sendName = () => {
		client.send("/app/hello", {}, JSON.stringify({ name }));
	};

	return (
		<Row gutter={20}>
			<Col span={24} style={{ marginBottom: 10 }}>
				<Button
					type={"primary"}
					onClick={connectWebsocket}
					disabled={connected}
					style={{
						marginRight: 20,
					}}
				>
					连接
				</Button>
				<Button
					type={"danger"}
					onClick={disconnectWebsocket}
					disabled={!connected}
				>
					断开连接
				</Button>
			</Col>
			<Col span={12} style={{ marginBottom: 10 }}>
				系统时间：(每秒系统主动广播websocket消息过来)
				<Input.TextArea
					readOnly
					autoSize={{ maxRows: 1, minRows: 1 }}
					value={sysTime}
				></Input.TextArea>
			</Col>
			<Col span={12} style={{ marginBottom: 10 }}>
				系统时间：（每两秒系统主动指定logan用户推送消息过来）
				<Input.TextArea
					readOnly
					autoSize={{ maxRows: 1, minRows: 1 }}
					value={sysTime2}
				></Input.TextArea>
			</Col>

			<Col
				span={24}
				style={{ display: "flex", alignItems: "center", marginBottom: 10 }}
			>
				<span style={{ marginRight: 10 }}>姓名:</span>
				<Input
					value={name}
					style={{ width: 200 }}
					onChange={({ target: { value } }) => setName(value)}
				></Input>
				<Button
					onClick={sendName}
					disabled={!connected}
					style={{ marginLeft: 10 }}
				>
					发送
				</Button>
			</Col>

			<Col span={24}>
				<Input.TextArea
					readOnly
					autoSize={{ maxRows: 1, minRows: 1 }}
					value={response}
				></Input.TextArea>
			</Col>
			<Col span={24}>
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
			</Col>
		</Row>
	);
};
