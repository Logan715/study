import React, { useEffect, useState } from "react";
import { Col, Row, Input, Button } from "antd";
import { PageTip } from "mouse-an";
import axios from "axios";
import uri from "host";
import { connect, disconnect } from "../../utils/websocktUtil";
export default () => {
	const [data, setData] = useState();
	const [message, setMessage] = useState();
	const [loading, setLoading] = useState(false);
	useEffect(() => {
		let client = null;
		let subscribe = {};
		subscribe["/mouse/logan/event"] = ({ body }) => setMessage(body);
		connect(`${uri}/ws`, {
			subscribe,
			success: (stompClient) => {
				client = stompClient;
				console.log("连接websocket成功");
			},
		});
		return () => {
			disconnect(client);
		};
	}, []);
	const fetchData = async () => {
		const response = await axios
			.get(`${uri}/event/test`)
			.finally(() => setLoading(false));
		setData(response.data);
	};
	return (
		<Row gutter={24}>
			<Col span={24} className="mouse-mb">
				<Button
					type="primary"
					loading={loading}
					onClick={() => {
						setLoading(true);
						fetchData();
					}}
				>
					click me fetch data then receive message after 2 seconds
				</Button>
			</Col>
			<Col span={12} className="mouse-mb">
				http返回: <Input readOnly value={data}></Input>
			</Col>
			<Col span={12} className="mouse-mb">
				事件通知websocket: <Input readOnly value={message}></Input>
			</Col>
			<Col span={24} className="mouse-mb">
				<PageTip>
					1. http请求后端, 返回请求时间，通过异步调用2秒钟之后调用应用事件通知。
					<br />
					2. 最后通过websocket返回后端时间。
				</PageTip>
			</Col>
		</Row>
	);
};
