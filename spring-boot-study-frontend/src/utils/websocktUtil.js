import Stomp from "stomp-websocket";
import SockJS from "sockjs-client";

export const connect = (url, options) => {
	const { subscribe = {}, success } = options;
	const socket = new SockJS(url);
	const stompClient = Stomp.over(socket);
	stompClient.connect({}, (frame) => {
		console.log("Connected: " + frame);
		const topics = Object.keys(subscribe);
		topics.map((topic) => {
			stompClient.subscribe(topic, subscribe[topic]);
		});
		success(stompClient);
	});
};

export const disconnect = (client) => {
	if (client !== null) {
		client.disconnect();
	}
};
