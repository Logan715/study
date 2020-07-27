import { createStore, applyMiddleware, combineReducers, compose } from "redux";
import thunk from "redux-thunk";


const reducer = (state={}, action) => {
	switch(action.type) {
		default: 
		return state;
	}
}
const storeTree = combineReducers({ reducer });

const composeEnhancers =
	typeof window === "object" && window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__
		? window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__({})
		: compose;

const enhancer = composeEnhancers(applyMiddleware(thunk));

const store = createStore(storeTree, enhancer);

export default store;
