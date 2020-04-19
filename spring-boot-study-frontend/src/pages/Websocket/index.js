import React, { useState } from "react";
import { Row, Col, Button, Input } from "antd";
import Stomp from "stomp-websocket";
import SockJS from "sockjs-client";

export default () => {
	const [connected, setConnected] = useState(false);
	const [client, setClient] = useState();
	const [response, setResponse] = useState();
	const [name, setName] = useState();
	const [sysTime, setSysTime] = useState();
	const [sysTime2, setSysTime2] = useState();
	const connect = () => {
		const socket = new SockJS("http://localhost:7070/gs-guide-websocket");
		const stompClient = Stomp.over(socket);
		stompClient.connect({}, (frame) => {
			setConnected(true);
			console.log("Connected: " + frame);
			stompClient.subscribe("/topic/greetings", function ({ body }) {
				setResponse(body);
			});
			stompClient.subscribe("/topic/sysTime", function ({ body: sysTime }) {
				setSysTime(sysTime);
			});
			stompClient.subscribe("/mouse/logan/sysTime", function ({
				body: sysTime,
			}) {
				setSysTime2(sysTime);
			});

			setClient(stompClient);
		});
	};

	const disconnect = () => {
		if (client !== null) {
			client.disconnect();
		}
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
					onClick={connect}
					disabled={connected}
					style={{
						marginRight: 20,
					}}
				>
					连接
				</Button>
				<Button type={"danger"} onClick={disconnect} disabled={!connected}>
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
		</Row>
	);
};
