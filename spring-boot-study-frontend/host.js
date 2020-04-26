let host = "";
try {
	if (process.env.NODE_ENV !== "production") {
		host = "http://localhost:7070";
	}
} catch (e) {
	console.error(e);
}

module.exports = host;
