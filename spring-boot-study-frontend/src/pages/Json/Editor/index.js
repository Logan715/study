import React from "react";
import JSONInput from "react-json-editor-ajrm";
import locale from "react-json-editor-ajrm/locale/en";
import themes from "react-json-editor-ajrm/es/themes";

export default () => {
	const onChange = (e, f) => {
		console.log(e, f);
	};
	return (
		<div>
			<JSONInput
				id="a_unique_id"
				placeholder={{ a: 10 }}
				colors={themes.light_mitsuketa_tribute}
				locale={locale}
				onKeyPressUpdate={false}
				height="550px"
				width="100%"
				onChange={onChange}
			/>
		</div>
	);
};
