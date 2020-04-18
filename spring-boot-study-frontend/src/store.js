import { createStore, applyMiddleware, combineReducers, compose } from "redux";
import thunk from "redux-thunk";

const storeTree = combineReducers({});

const composeEnhancers =
	typeof window === "object" && window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__
		? window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__({})
		: compose;

const enhancer = composeEnhancers(applyMiddleware(thunk));

const store = createStore(storeTree, enhancer);

export default store;
