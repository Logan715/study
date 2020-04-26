import React, { useState } from "react";
import { Row, Col, Button, Input } from "antd";
import { connect, disconnect } from "../../utils/websocktUtil";
import Tips from "./Tips";
import uri from "host";
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
		connect(`${uri}/ws`, { subscribe, success });
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
			<Col span={24} className="mouse-mb">
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
			<Col span={12} className="mouse-mb">
				系统时间：(每秒系统主动广播websocket消息过来)
				<Input.TextArea
					readOnly
					autoSize={{ maxRows: 1, minRows: 1 }}
					value={sysTime}
				></Input.TextArea>
			</Col>
			<Col span={12} className="mouse-mb">
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
				<Tips />
			</Col>
		</Row>
	);
};
